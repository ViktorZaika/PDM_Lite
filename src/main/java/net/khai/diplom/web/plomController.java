package net.khai.diplom.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import net.khai.diplom.web.MyBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import net.khai.diplom.sigma.*;
import net.khai.diplom.domain.ORG_STR_Element;
import net.khai.diplom.domain.Project_Files_Links;
import net.khai.diplom.domain.Project_Units_Links;
import net.khai.diplom.domain.Provider;
import net.khai.diplom.domain.Wokers;
import net.khai.diplom.domain.Files;
import net.khai.diplom.service.FileService;
import net.khai.diplom.service.ORG_STR_ElementService;
import net.khai.diplom.service.Project_Units_LinksService;
import net.khai.diplom.service.ProviderService;
import net.khai.diplom.service.UnitService;
import net.khai.diplom.service.Unit_Files_LinksService;
import net.khai.diplom.service.WokersService;
import net.khai.diplom.service.Project_File_LinksService;
//import net.khai.diplom.web.Upload;
import net.khai.diplom.domain.Project;
import net.khai.diplom.service.ProjectService;
import net.khai.diplom.tree.Tree;
import net.khai.diplom.domain.Unit;
import net.khai.diplom.domain.Rules;
import net.khai.diplom.service.RulesService;


//import org.neo4j.cypher.internal.compiler.v2_1.ast.rewriters.addUniquenessPredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class plomController {
	@Autowired
	public ProjectService projectService;
	
	@Autowired
	public FileService fileService;

	@Autowired
	public UnitService unitService ;

	@Autowired
	public Unit_Files_LinksService unit_Files_LinksService;

	@Autowired
	public Project_Units_LinksService project_Units_LinksService;

	@Autowired
	public Project_File_LinksService project_FILE_LinksService;
	
	@Autowired
	private ProviderService providerService;

	@Autowired
	private RulesService rulesService;
	
	@Autowired
	private ORG_STR_ElementService oRG_STR_ElementService;
	
	@Autowired
	private WokersService wokersService;

	public void BuildTree(JspWriter out) throws IOException{
		
		out.println("ololo");
	projectService.listProject();
	}
	
	@RequestMapping("/provider")
	public String listProvider(Map<String, Object> map) {

		map.put("provider", new Provider());
		map.put("providerList", providerService.listProvider());

		return "provider";
	}
	
	@RequestMapping("/index")
	public String home_1() {
		return "redirect:/home";
	}
	@RequestMapping("/")
	public String home() {
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home_home() {
		return "home";
	}
	@RequestMapping("/three")
	public String three() {
		return "three";
	}
	@RequestMapping("/sigmaGraph")
	public String Sigma(Map<String, Object> map)
	{ sigma sigma = new sigma();
	    sigma.generateGraph(projectService.listProject(),1);
	    map.put("sigma",sigma);
		   return "sigmaGraph";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProvider(@ModelAttribute("provider") Provider provider,
			BindingResult result) {

		providerService.addProvider(provider);

		return "redirect:/provider";
	}

	@RequestMapping("/delete/{providerid}")
	public String deleteProvider(@PathVariable("providerid") Integer providerId) {

		providerService.removeProvider(providerId);

		return "redirect:/provider";
	}

	

	@RequestMapping("/project")
	public String listProject(Map<String, Object> map) {

		map.put("project", new Project());
		map.put("projectList", projectService.listProject());

		return "project";
	}
    
	@RequestMapping(value = "/addproject/{over_proj}", method = RequestMethod.POST)
	public String addProject(@PathVariable("over_proj") Integer over_proj,@ModelAttribute("project") Project project,
			BindingResult result) {
        if(project.getLinks()==null){project.setLinks(Integer.toString(over_proj));}		
		project.setOver_proj(over_proj);
		projectService.addProject(project);

		return "redirect:/tree";
	}
    
	@RequestMapping(value = "/add_unit_in_proj/{proj_id}")
	public String addUnitInProj(@PathVariable("proj_id") Integer proj_id, Map<String,Object> map) {
		map.put("myRef",proj_id);
		map.put("unit", new Unit());
		List<Wokers> Wlist= wokersService.listWokers();
		System.out.println(Wlist.get(0).getName() +"myCheck");
		map.put("wokers", Wlist);
		

		return "project_unit_form";
	}
	@RequestMapping(value = "/add_unit/{project_id}", method = RequestMethod.POST)
	public String addUnit(@PathVariable("project_id") Integer project_id,@ModelAttribute("unit") Unit unit,
			BindingResult result) {
		unit.setOver_unit(0);
        unitService.addUnit(unit);
        Project_Units_Links link =new Project_Units_Links();
        link.setProject_id(project_id);
        
        for (Unit unt : unitService.listUnit()) {
			
        if (unt.getName().equals(unit.getName()))
        {
        	link.setUnit_id(unt.getId());
        }
        
        }
        
		project_Units_LinksService.addProject_Units_Links(link);

		return "redirect:/Units";
	}
	
	
	@RequestMapping("/deleteproject/{projectid}")
	public String deleteProject(@PathVariable("projectid") Integer projectId) {

		projectService.removeProject(projectId);

		return "redirect:/tree";
	}
	@RequestMapping("/UploadServlet")
	public String FileUpload()
	{
		
		 
		return "UploadFile";
	}
	@RequestMapping("/tree")
	public String tree(Map<String, Object> map) {
       Tree tree = new Tree();
       tree.generateTree(projectService,fileService,unitService,unit_Files_LinksService,project_Units_LinksService,project_FILE_LinksService);
       map.put("tree",tree);
		map.put("project", new Project());
		map.put("projectList", projectService.listProject());
		//System.out.println(projectService.listProject().iterator().next().getName());
		 
		return "tree";
	}
// load part
	@RequestMapping(value = "/addunit/{unitid}", method = RequestMethod.POST)
	public String addunit(@PathVariable("unitid") Integer unitid,@ModelAttribute("unit") Unit unit,
			BindingResult result) {
		unit.setOver_unit(unitid);
        unitService.addUnit(unit);
		

		return "redirect:/Units";
	}

	@RequestMapping("/getUnit/{unitid}")
	public String UnitItem(Map<String, Object> map,@PathVariable("unitid") Integer unitId) {
         int k =unitId;
		for(int i=0; i < unitService.listUnit().size(); i++)
		{
			if(unitService.listUnit().get(i).getId()== k){            
				map.put("unit",unitService.listUnit().get(i));
				}
		}
                
		
		
		return "unitform";
	}
	
	@RequestMapping("/deleteunit/{unitid}")
	public String deleteUnit(@PathVariable("unitid") Integer unitid) {
		unitService.removeUnit(unitid);
		
		

		return "redirect:/Units";
	}
	@RequestMapping("/getProject/{projectid}")
	public String ProjectItem(Map<String, Object> map,@PathVariable("projectid") Integer projectId) {
         
		int k =projectId;
		for(int i=0; i < projectService.listProject().size(); i++)
		{
			if(projectService.listProject().get(i).getId()== k){            
				map.put("project",projectService.listProject().get(i));
				}
		}                 
		
		map.put("ProjectList", projectService.listProject());
		System.out.print("here!");
		return "projectform";
	}
	@RequestMapping("/fileform/{pr_id}")
	public String getFileForm(Map<String, Integer> map,Map<String, Object> map2,@PathVariable("pr_id") Integer pr_id) {
		map.put("pr_id", pr_id);
		map2.put("file", new Files());
	return"fileform";
	}
	@RequestMapping(value = "/add_file_in_project/{pr_id}", method = RequestMethod.POST)
	public String addFile_in_project(@PathVariable("pr_id") Integer pr_id,@ModelAttribute("file") Files file,
			BindingResult result) {
    Project_Files_Links project_File_Links= new Project_Files_Links();

	
	fileService.addFile(file);
	List<Files> fl=fileService.listFile();

	
    for (int i = 0;i <fl.size();i++){
    	
    	if (file.getName().equals(fl.get(i).getName()))
    {   System.out.println(fl.get(i).getName());
        
        int a =fl.get(i).getId();
        project_File_Links.setFile_id(a);
        project_File_Links.setProject_id(pr_id);
    	project_FILE_LinksService.addProject_File_Links(project_File_Links);
    }}
	
		return "redirect:/tree";
	}
	@RequestMapping("/getFile/{fileid}")
	public String FileItem(Map<String, Object> map,@PathVariable("fileid") Integer fileId) {

		int k =fileId;
		for(int i=0; i < fileService.listFile().size(); i++)
		{
			if(fileService.listFile().get(i).getId()== k){            
				map.put("file",fileService.listFile().get(i));
				}
		}                 
		
		return "fileform";
	}
	@RequestMapping("/Units")
	public String Units(Map<String, Object> map) {
       Tree tree = new Tree();
       tree.generateUnitsTree(projectService,fileService,unitService,unit_Files_LinksService,project_Units_LinksService);
       map.put("tree",tree);
		map.put("project", new Project());
		map.put("projectList", projectService.listProject());
		//System.out.println(projectService.listProject().iterator().next().getName());
		 
		return "Units";
	}	
	@RequestMapping("/rules")
	public String Rules(Map<String, Object> map) {

		map.put("Rules", new Rules());
		map.put("RulesList", rulesService.listRules());
		
		return "rules";
	}
	@RequestMapping("/org_str")
	public String Org_str(Map<String, Object> map) {
		Tree tree = new Tree();
	       tree.generateORG_STRTree(oRG_STR_ElementService, wokersService);
	       map.put("tree",tree);
		    //map.put("project", new Project());
			//map.put("projectList", projectService.listProject());
		return "org_str";
	}
	@RequestMapping("/getRule/{ruleid}")
	public String RulesForm(Map<String, Object> map,@PathVariable("ruleid") Integer ruleId) {
        MyBean myBean= new MyBean();
		int k =ruleId;
	
		int a =0;
		for(int i=0; i < rulesService.listRules().size(); i++)
		{
			if(rulesService.listRules().get(i).getId()== k){            
				a =rulesService.listRules().get(i).getFile_id();
				myBean.doc_name=rulesService.listRules().get(i).getDoc_name();
				myBean.code=rulesService.listRules().get(i).getCode();
				myBean.change="changerule/"+rulesService.listRules().get(i).getId();
				myBean.delete="deleterule/"+rulesService.listRules().get(i).getId();
				myBean.download="#";
				}
		}          
		for(int i=0; i < fileService.listFile().size(); i++)
		{
			if(fileService.listFile().get(i).getId()==a){            
				
				myBean.name=fileService.listFile().get(i).getName();
				myBean.description=fileService.listFile().get(i).getDescription();
				myBean.extention=fileService.listFile().get(i).getExtention();
				myBean.version=fileService.listFile().get(i).getVersion();
				myBean.add_date=fileService.listFile().get(i).getAdd_date();
				myBean.manager=fileService.listFile().get(i).getManager();
				myBean.role=fileService.listFile().get(i).getRole();
				myBean.size=fileService.listFile().get(i).getSize();
				
				
				map.put("file",myBean);
			}
		}     
		return "fileruleform";
	}
	@RequestMapping("/getRule/0")
	public String RulesEForm(Map<String, Object> map) {
		map.put("rules",new MyBean());	
		
	     
		return "fileruleeform";
	}
	
	@RequestMapping("/deleterule/{ruleid}")
	public String deleteRule(@PathVariable("ruleid") Integer ruleId) {
		List<Rules> rulelist= rulesService.listRules();
		int a = ruleId;
		for(int i=0; i < rulelist.size(); i++)
		{
			if(rulelist.get(i).getId()==a){rulesService.removeRules(a); fileService.removeFile(rulelist.get(i).getFile_id());}
			
		}     
		
		

		return "redirect:/rules";
	}
	@RequestMapping("/changerule/{ruleid}")
	public String changeRule(@PathVariable("ruleid") Integer ruleId,@ModelAttribute("file") MyBean myBean,
			BindingResult result) {
		List<Rules> rulelist= rulesService.listRules();
		int a = ruleId;
		for(int i=0; i < rulelist.size(); i++)
		{
			if(rulelist.get(i).getId()==a){rulesService.removeRules(a); fileService.removeFile(rulelist.get(i).getFile_id());}
			
		}     
		
		 Files file = new Files();
	        Rules rules= new Rules();
			

			file.setName(myBean.name);
			file.setDescription(myBean.description);
			file.setExtention(myBean.extention);
			file.setVersion(myBean.version);
			
		    file.setManager(myBean.manager);
			file.setRole(myBean.role);
			file.setSize(myBean.size);
			fileService.addFile(file);
			List<Files> filelist= fileService.listFile();
			 a = 0;
			for(int i=0; i < filelist.size(); i++)
			{
				if(filelist.get(i).getId()>a){ a=filelist.get(i).getId();}
				
			}          
					
			
			rules.setFile_id(a);
			rules.setDoc_name(myBean.doc_name);
			rules.setCode(myBean.code);
			       
	        rulesService.addRules(rules);
			

		return "redirect:/rules";
	}
	@RequestMapping("/searchrule1")
	public String searchRule(Map<String, Object> map,@ModelAttribute("file") MyBean myBean) {
		
	
		     
		return "redirect:/rules";
	}
	@RequestMapping("/searchrule")
	public String searchRuleForm(Map<String, Object> map) {
		
		map.put("rules", new MyBean());
		     
		return "/searchrule";
	}
	@RequestMapping("/getOrg/{orgid}")
	public String getOrg(Map<String, Object> map,@PathVariable("orgid") Integer fileId) {
		List<ORG_STR_Element> ORG_STRList=oRG_STR_ElementService.listORG_STR_Element();
		int k =fileId;
		for(int i=0; i < ORG_STRList.size(); i++)
		{
			if(ORG_STRList.get(i).getId()== k){            
				map.put("Element",ORG_STRList.get(i));
				}
		}                 
		
		return "elemform";
	}//////////////////////////////////////////

@RequestMapping("/deleteOrg/{id}")
public String deleteOrg_elem(@PathVariable("id") Integer Id) {
	List<Wokers> wokerlist=wokersService.listWokers();
	List<ORG_STR_Element> orglist=oRG_STR_ElementService.listORG_STR_Element();
	int a = Id;
	System.out.println(a);
	for(int i = 0;i< wokerlist.size();i++)
	{
		if(wokerlist.get(i).getId_ORG()==a){wokersService.removeWokers(wokerlist.get(i).getId());}
	}
	
	 oRG_STR_ElementService.removeORG_STR_Element(a);
	
	

	return "redirect:/org_str";
}
	@RequestMapping(value = "/addorg_elem/{orgid}", method = RequestMethod.POST)
	public String addProvider(@PathVariable("orgid") Integer orgid,@ModelAttribute("org_elem") ORG_STR_Element org_elem,
			BindingResult result) {

	   org_elem.setOver_element(orgid);
		oRG_STR_ElementService.addORG_STR_Element(org_elem);

		return "redirect:/org_str";
	}
	@RequestMapping("/getWoker/{wokerid}")
	public String getwoker(Map<String, Object> map,@PathVariable("wokerid") Integer wokerId) {
		List<Wokers> wokerlist=wokersService.listWokers();
		int k =wokerId;
		for(int i=0; i < wokerlist.size(); i++)
		{
			if(wokerlist.get(i).getId()== k){            
				map.put("woker",wokerlist.get(i));
				}
		}                 
		
		return "wokersform";
	}
	@RequestMapping("/getewokerform/{elemid}")
	public String getWokerform(Map<String, Object> map,@PathVariable("elemid") Integer elemId) {
		List<Wokers> wokerlist=wokersService.listWokers();
		int k =elemId;
		         Wokers woker = new Wokers();
		         woker.setId_ORG(elemId);
				map.put("woker",woker);
		        
		return "wokerform";
	}
	@RequestMapping(value = "/addwoker/{orgid}", method = RequestMethod.POST)
	public String addwoker(@PathVariable("orgid") Integer orgid,@ModelAttribute("woker") Wokers woker,
			BindingResult result) {

	  woker.setId_ORG(orgid);
		wokersService.addWokers(woker);

		return "redirect:/org_str";
	}
	@RequestMapping("/deletewoker/{id}")
	public String deletewoker(@PathVariable("id") Integer Id) {
		List<Wokers> wokerlist=wokersService.listWokers();
		int a = Id;
		System.out.println(a);
		wokersService.removeWokers(a);	
		 
		
		

		return "redirect:/org_str";
	}
	
	
	@RequestMapping(value = "/addrule", method = RequestMethod.POST)
	public String addrule(@ModelAttribute("rules") MyBean myBean,
			BindingResult result) {
        Files file = new Files();
        Rules rules= new Rules();
		

		file.setName(myBean.name);
		file.setDescription(myBean.description);
		file.setExtention(myBean.extention);
		file.setVersion(myBean.version);
		
	    file.setManager(myBean.manager);
		file.setRole(myBean.role);
		file.setSize(myBean.size);
		fileService.addFile(file);
		List<Files> filelist= fileService.listFile();
		int a = 0;
		for(int i=0; i < filelist.size(); i++)
		{
			if(filelist.get(i).getId()>a){ a=filelist.get(i).getId();}
			
		}          
				
		
		rules.setFile_id(a);
		rules.setDoc_name(myBean.doc_name);
		rules.setCode(myBean.code);
		       
        rulesService.addRules(rules);
		

		return "redirect:/rules";
	}
	
	/*@RequestMapping(value = "/addrule", method = RequestMethod.POST)
	public String saveFile(@ModelAttribute("rules") Rules myBean,
			BindingResult result,@RequestParam("MyFileName") MultipartFile file) {
	
		System.out.println("File name:" + file.getOriginalFilename());
		System.out.println("Вот размер файла:");
		System.out.println(file.getSize());

		String orgName = file.getOriginalFilename();
		String filePlaceToUpload = "/home/vikt/WS/";
		String filePath = filePlaceToUpload + orgName;
		File dest = new File(filePath);
		try {
			file.transferTo(dest);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		Files files = new Files();
        Rules rules= new Rules();
		

		files.setName(myBean.name);
		files.setDescription(myBean.description);
		files.setExtention(myBean.extention);
		files.setVersion(myBean.version);
		
	    files.setManager(myBean.manager);
		files.setRole(myBean.role);
		files.setSize(myBean.size);
		//fileService.addFile(files);
		System.out.println(myBean.description);
		System.out.println(myBean.name);
		List<Files> filelist= fileService.listFile();
		int a = 0;
		for(int i=0; i < filelist.size(); i++)
		{
			if(filelist.get(i).getId()>a){ a=filelist.get(i).getId();}
			
		}          
				
		
		rules.setFile_id(a);
		rules.setDoc_name(myBean.doc_name);
		rules.setCode(myBean.code);
		       
        //rulesService.addRules(rules);
	
		return "redirect:/rules";
	}*/
}
