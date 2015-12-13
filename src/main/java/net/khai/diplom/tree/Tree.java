package net.khai.diplom.tree;
import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import net.khai.diplom.service.ProjectServiceImpl;
import net.khai.diplom.service.ProjectService;
import net.khai.diplom.service.ProviderService;
import net.khai.diplom.domain.ORG_STR_Element;
import net.khai.diplom.domain.Project;
import net.khai.diplom.domain.Files;
import net.khai.diplom.domain.Project_Files_Links;
import net.khai.diplom.domain.Project_Units_Links;
import net.khai.diplom.domain.Unit;
import net.khai.diplom.domain.Wokers;
import net.khai.diplom.domain.Project_Files_Links;


import net.khai.diplom.domain.Unit_Files_Links;
import net.khai.diplom.service.ORG_STR_ElementService;
import net.khai.diplom.service.Project_File_LinksService;
import net.khai.diplom.service.Project_Units_LinksService;
import net.khai.diplom.service.Unit_Files_LinksService;
import net.khai.diplom.service.FileService;
import net.khai.diplom.service.UnitService;
import net.khai.diplom.service.Unit_Files_LinksServiceImpl;
import net.khai.diplom.service.WokersService;

import java.util.List;

public class Tree  {
	
static String Treetags;
public String BuildPart(int id_heiht,List<Project> projectservice,List<Project_Units_Links> project_Units_Linkslist,List<Unit> unitlist,List<Files> filelis, List<Unit_Files_Links> unit_Files_Linkslist,List<Project_Files_Links> prfilelist)
{ String PartTree;
PartTree="<ul>";

for(int j = 0;j < project_Units_Linkslist.size();j++)
{ 
	 int a = project_Units_Linkslist.get(j).getProject_id();
     if(id_heiht== a)
	{
		for(int k =0; k<unitlist.size();k++)
		{   int b =project_Units_Linkslist.get(j).getUnit_id();
			if(unitlist.get(k).getId()==b)
			{
				PartTree+="<li data-jstree='{\"icon\":\"resources/unit.png\"}'><a onclick=\"showContent('getUnit/"+unitlist.get(k).getId()+"')\">"+unitlist.get(k).getName()+"</a>"+BuildUnit(project_Units_Linkslist.get(j).getUnit_id(), filelis, unit_Files_Linkslist,unitlist)+"</a></li>";
				
			}
		}
	}
}

for (int i =0 ;i < projectservice.size(); i++){
	if (projectservice.get(i).getOver_proj()==id_heiht)
			{
	         PartTree+="<li ><a onclick=\"showContent('getProject/"+projectservice.get(i).getId()+"')\">"+projectservice.get(i).getName()+"</a>"+BuildPart(projectservice.get(i).getId(),projectservice,project_Units_Linkslist,unitlist,filelis,unit_Files_Linkslist,prfilelist)+"</li>";
	         
			} 
	
}
for (int i = 0;i < prfilelist.size();i++)
{if (prfilelist.get(i).getProject_id() ==id_heiht)
{ 
	 for (int j=0;j< filelis.size();j++){int c =prfilelist.get(i).getFile_id();
	 if (filelis.get(j).getId()==c)
			 {
		       PartTree+="<li data-jstree='{\"icon\":\"resources/file.png\"}'><a onclick=\"showContent('getFile/"+filelis.get(j).getId()+"')\">"+filelis.get(j).getName()+"."+filelis.get(j).getExtention()+"</a></li>";
			 }
	 }
	 
	 
}
}
PartTree+="</ul>";

	return PartTree;
}	

public String BuildUnitPart(int id_heiht,List<Project> projectservice,List<Project_Units_Links> project_Units_Linkslist,List<Unit> unitlist,List<Files> filelis, List<Unit_Files_Links> unit_Files_Linkslist)
{ String PartTree;
System.out.println(id_heiht);
PartTree="<ul>";

for(int j = 0;j < project_Units_Linkslist.size();j++)
{ 
	 int a = project_Units_Linkslist.get(j).getProject_id();
     if(id_heiht== a)
	{
		for(int k =0; k<unitlist.size();k++)
		{   int b =project_Units_Linkslist.get(j).getUnit_id();
			if(unitlist.get(k).getId()==b)
			{
				PartTree+="<li data-jstree='{\"icon\":\"resources/unit.png\"}'><a onclick=\"showContent('getUnit/"+unitlist.get(k).getId()+"')\">"+unitlist.get(k).getName()+"</a>"+BuildUnit(project_Units_Linkslist.get(j).getUnit_id(), filelis, unit_Files_Linkslist,unitlist)+"</a></li>";
				
			}
		}
	}
     
     
}
PartTree+="</ul>";

	return PartTree;
}	


public String BuildUnit(int Unit_id,List<Files> filelis,List<Unit_Files_Links> unit_Files_Linkslist,List<Unit> unitlist)
{   
	String UnitTag="<ul>";
	 //for (int i=0;i)
	System.out.println("unit: "+Unit_id);
	for (int i =0 ;i < unitlist.size(); i++){
		if (unitlist.get(i).getOver_unit()==Unit_id)
				{
			UnitTag+="<li data-jstree='{\"icon\":\"resources/unit.png\"}'><a onclick=\"showContent('getUnit/"+unitlist.get(i).getId()+"')\">"+unitlist.get(i).getName()+"</a>"+BuildUnit(unitlist.get(i).getId(),filelis,unit_Files_Linkslist,unitlist)+"</li>";
		         
				} 
		
	}
	 
	for (int i = 0;i < unit_Files_Linkslist.size();i++)
	 {if (unit_Files_Linkslist.get(i).getUnit_id()==Unit_id)
	 { 
		 for (int j=0;j< filelis.size();j++){int c =unit_Files_Linkslist.get(i).getFile_id();
		 if (filelis.get(j).getId()==c)
				 {
			       UnitTag+="<li data-jstree='{\"icon\":\"resources/file.png\"}'><a onclick=\"showContent('getFile/"+filelis.get(j).getId()+"')\">"+filelis.get(j).getName()+"."+filelis.get(j).getExtention()+"</a></li>";
				 }
		 }
		 
		 
	 }
	 }
	     UnitTag+="</ul>";
	     
		 return UnitTag;
}


public void generateUnitsTree(ProjectService projectService,FileService fileService,UnitService unitService,Unit_Files_LinksService unit_Files_LinksService,Project_Units_LinksService project_Units_LinksService)
	{List<Files> filelist= fileService.listFile();
	 List<Unit> unitlist= unitService.listUnit();
	 List<Unit_Files_Links> unit_Files_Linkslist= unit_Files_LinksService.listUnit_Files_Links();
	 List<Project_Units_Links> project_Units_Linkslist=project_Units_LinksService.listProject_Units_Links();
	 List<Project> projectlist = projectService.listProject();	
	// System.out.println(filelist.get(2).getName());
	 
	 
	Treetags="<ul>";
	for (int i =0 ;i < projectlist.size(); i++){
		if (projectlist.get(i).getOver_proj()==0){ Treetags+= "<li ><a onclick=\"showContent('getProject/"+projectlist.get(i).getId()+"')\">"+projectlist.get(i).getName()+"</a>"+BuildUnitPart(projectlist.get(i).getId(), projectlist,project_Units_Linkslist,unitlist,filelist,unit_Files_Linkslist)+"</li>";}
		
	}Treetags=Treetags+"</ul>";
	System.out.println(Treetags);
	}
public void generateORG_STRTree(ORG_STR_ElementService org_STR_ElementService,WokersService wokersService)
{List<ORG_STR_Element> ORG_STRList=org_STR_ElementService.listORG_STR_Element();
 List<Wokers> WokersList=wokersService.listWokers();
 Treetags="<ul>";
	for (int i =0 ;i < ORG_STRList.size(); i++){
		if (ORG_STRList.get(i).getOver_element()==0){ Treetags+= "<li><a onclick=\"showContent('getOrg/"+ORG_STRList.get(i).getId()+"')\">"+ORG_STRList.get(i).getName()+"</a>"+BuildORG_STRPart(ORG_STRList.get(i).getId(), ORG_STRList,WokersList)+"</li>";}
		
	}Treetags=Treetags+"</ul>";
 
}
public String BuildORG_STRPart(int id_heiht,List<ORG_STR_Element> orgList,List<Wokers> wokersList)
{ String PartTree;
PartTree="<ul>";
for (int i =0 ;i < orgList.size(); i++){
	if (orgList.get(i).getOver_element()==id_heiht)
			{
	         PartTree+="<li data-jstree='{\"icon\":\"resources/org.png\"}'><a  onclick=\"showContent('getOrg/"+orgList.get(i).getId()+"')\">"+orgList.get(i).getName()+"</a>"+BuildORG_STRPart(orgList.get(i).getId(),orgList,wokersList)+"</li>";
	         
			} 
	
}int a =id_heiht;
for (int i = 0 ;i<wokersList.size();i++)
{ if (wokersList.get(i).getId_ORG()==a)
{
	 PartTree+="<li data-jstree='{\"icon\":\"resources/user.png\"}'><a onclick=\"showContent('getWoker/"+wokersList.get(i).getId()+"')\">"+wokersList.get(i).getName()+"</a></li>";
	 	
}
	
}

PartTree+="</ul>";

	return PartTree;
}	

public void generateTree(ProjectService projectService,FileService fileService,UnitService unitService,Unit_Files_LinksService unit_Files_LinksService,Project_Units_LinksService project_Units_LinksService,Project_File_LinksService project_File_LinksService)
	{List<Project_Files_Links> prfilelist = project_File_LinksService.listProject_File_Links();
	 List<Files> filelist= fileService.listFile();
	 List<Unit> unitlist= unitService.listUnit();
	 List<Unit_Files_Links> unit_Files_Linkslist= unit_Files_LinksService.listUnit_Files_Links();
	 List<Project_Units_Links> project_Units_Linkslist=project_Units_LinksService.listProject_Units_Links();
	 List<Project> projectlist = projectService.listProject();	
	// System.out.println(filelist.get(2).getName());
	 
	 
	Treetags="<ul>";
	for (int i =0 ;i < projectlist.size(); i++){
		if (projectlist.get(i).getOver_proj()==0){ Treetags+= "<li ><a onclick=\"showContent('getProject/"+projectlist.get(i).getId()+"')\">"+projectlist.get(i).getName()+"</a>"+BuildPart(projectlist.get(i).getId(), projectlist,project_Units_Linkslist,unitlist,filelist,unit_Files_Linkslist,prfilelist)+"</li>";}
		
	}Treetags=Treetags+"</ul>";
	System.out.println(Treetags);
	}

	public String getTreetags() {
		
		return this.Treetags;
	}
	public void setTreetags(String treetags) {
		this.Treetags = treetags;
	}
}
