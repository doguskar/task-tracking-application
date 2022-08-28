# Task Tracking Application
## Database UML
![database uml](/src/main/resources/static/task-tracking-application.drawio.png)

## Services 
### Task Services 
#### Get Task
    GET /api/v1/projects/{projectId}/task-lists/{taskListsId}/tasks/{taskId}
#### Response Body
    {
        "id": 8,
        "pk": "f9d1bbbd-dba7-47a6-9461-d2468a1c51a3",
        "title": "Authorization",
        "description": "Implement authorization with spring security"
    }
---
#### Add Task
    POST /api/v1/projects/{projectId}/task-lists/{taskListsId}/tasks
#### Request Body
    {
        "title": "Authorization",
        "description": "Implement authorization with spring security"
    }
#### Response
    201 created 
---
#### Partial Update Task
    PATCH /api/v1/projects/{projectId}/task-lists/{taskListsId}/tasks
#### Request Body
    {
        "title": "Authorization",
        "description": "Implement authorization with spring security",
        "taskListId": 4
    }
#### Response
    204 no content 
---
#### Delete Task
    DELETE /api/v1/projects/{projectId}/task-lists/{taskListsId}/tasks/{taskId}
#### Response
    204 no content 
