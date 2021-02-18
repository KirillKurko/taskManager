export default class ProjectServiceService {

    _apiBase = "http://localhost:8080/api";

    getResource = async (url) => {
        const res = await fetch(`${this._apiBase}${url}`);
        if (!res.ok) {
            throw new Error(`Could not fetch ${url}, received ${res.status}`);
        }
        return await res.json();
    }

    getProjects = async () => {
        const res = await this.getResource("/projects");
        return res.json();
    }

    getProject = async (id) => {
        return await this.getResource(`/project/${id}`);
    }

    saveProject = async (project) => {
        const res = await fetch(`${this._apiBase}/projects`,
            {method: project.id ? "PUT" : "POST",
                headers: {'Accept': 'application/json',
                          'Content-Type': 'application/json'
                },
                body: JSON.stringify(project)
            });
        return await res.json();
    }

    deleteProject = async (id) => {
        const res = await fetch(`${this._apiBase}/projects/${id}`, {method: "DELETE"});
        return await res.json();
    }

    addTask = async (id, task) => {
        const res = await fetch(`${this._apiBase}/projects/${id}`,
            {method: "PUT",
                headers: {'Accept': 'application/json',
                          'Content-Type': 'application/json'
                },
                body: JSON.stringify(task)
            });
        return await res.json();
    }
}