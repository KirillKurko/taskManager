export default class EmployeeService {

    _apiBase = "http://localhost:8080/api";

    getResource = async (url) => {
        const res = await fetch(`${this._apiBase}${url}`);
        if (!res.ok) {
            throw new Error(`Could not fetch ${url}, received ${res.status}`);
        }
        return await res.json();
    }

    getEmployees = async () => {
        const res = await this.getResource("/employees");
        return res.json();
    }

    getEmployee = async (id) => {
        return await this.getResource(`/employees/${id}`);
    }

    saveEmployee = async (employee) => {
        const res = await fetch(`${this._apiBase}`,
                                {method: employee.id ? "PUT" : "POST",
                                     headers: {'Accept': 'application/json',
                                               'Content-Type': 'application/json'
                                               },
                                     body: JSON.stringify(employee)
                                });
        return await res.json();
    }

    deleteEmployee = async (id) => {
        const res = await fetch(`${this._apiBase}/employees/${id}`, {method: "DELETE"});
        return await res.json();
    }

    addTask = async (id, task) => {
        const res = await fetch(`${this._apiBase}/employees/${id}`,
                            {method: "PUT",
                                headers: {'Accept': 'application/json',
                                          'Content-Type': 'application/json'
                                },
                                body: JSON.stringify(task)
                            });
        return await res.json();
    }
}