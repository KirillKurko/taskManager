export default class TaskService {

    _apiBase = "http://localhost:8080/api";

    getResource = async (url) => {
        const res = await fetch(`${this._apiBase}${url}`);
        if (!res.ok) {
            throw new Error(`Could not fetch ${url}, received ${res.status}`);
        }
        return await res.json();
    }

    getTasks = async () => {
        const res = await this.getResource("/tasks");
        return res.json();
    }

    getTask = async (id) => {
        return await this.getResource(`/tasks/${id}`);
    }

    saveTask = async (task) => {
        const res = await fetch(`${this._apiBase}/tasks`,
            {method: task.id ? "PUT" : "POST",
                headers: {'Accept': 'application/json',
                          'Content-Type': 'application/json'
                },
                body: JSON.stringify(task)
            });
        return await res.json();
    }

    deleteTask = async (id) => {
        const res = await fetch(`${this._apiBase}/tasks/${id}`, {method: "DELETE"});
        return await res.json();
    }

    addEmployee = async (id, employee) => {
        const res = await fetch(`${this._apiBase}/tasks/${id}`,
            {method: "PUT",
                headers: {'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(employee)
            });
        return await res.json();
    }
}