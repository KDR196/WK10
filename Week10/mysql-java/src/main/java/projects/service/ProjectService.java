package projects.service;

import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectsDao;
import projects.entity.Project;

public class ProjectService {
	private ProjectsDao projectsDao = new ProjectsDao();
	
	public Project addProject(Project project) {
		return projectsDao.insertProject(project);
	}
	
	public List<Project> fetchAllProjects() {
		return ((ProjectsDao) projectsDao).fetchAllProjects();
	}
	
	public Project fetchProjectById(Integer projectId) {
		return projectsDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException(
				"Project with project ID = " + projectId + " does not exist"));
	}
}
