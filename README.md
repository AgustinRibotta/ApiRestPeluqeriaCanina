

#### **Owner**

---

### **Create a Owner**
- **URL:** `/api/v1/owner/`
- **Method:** `POST`
- **Requires Authentication:** No
- **Description:** Creates a new owner.

##### **Request Body:**
```json
{
  "name": "name",
  "telOwner": "+231431"
}
```

##### **Successful Response (201 Created):**
```json
{
  "id": 1,
  "name": "name",
  "telOwner": "+231431",
	"petNames": []
}
```

##### **Errors:**
| Code | Description                        | Example Response              |
|------|------------------------------------|--------------------------------|
| 409  | Conflict        								    | "error", "The owner's phone number is already registered." |

---

### **Read a Owner**
#### **Retrieve a Single Resource**
- **URL:** `/api/v1/owner/<id>/`
- **Method:** `GET`
- **Requires Authentication:** No
- **Description:** Retrieves details of a Owner.


##### **Successful Response (200 OK):**
```json
{
  "id": 1,
  "name": "name",
  "telOwner": "+231431",
	"petNames": []
}
```

##### **Errors:**
| Code | Description          | Example Response          |
|------|----------------------|---------------------------|
| 404  |  Not Found.  | "error", "No owner found with that ID.."|

---

#### **List All Owner**
- **URL:** `/api/owner/`
- **Method:** `GET`
- **Requires Authentication:** no
- **Description:** Retrieves a list of all Owner .


##### **Successful Response (200 OK):**
```json
[
  {
    "id": 1,
    "name": "name",
    "telOwner": "+231431",
		"petNames": []
  },
  {
    "id": 2,
    "name": "name2",
    "telOwner": "+2314313",
		"petNames": []
  }
]
```

##### **Possibility:**
| Code | Description          | Example Response          |
|------|----------------------|---------------------------|
| 204  |  No Content          | "message", "No elements available yet."|


---

### **Update a Owner**
- **URL:** `/api/owner/<id>/`
- **Method:** `PUT`
- **Requires Authentication:** No
- **Description:** Updates an existing Owner.

##### **Request Body:**
```json
{
    "name": "name3",
    "telOwner": "+2314313"
}
```

##### **Successful Response (200 OK):**
```json
{
    "id": 1,
    "name": "name3",
    "telOwner": "+231431",
		"petNames": []
}
```

##### **Errors:**
| Code | Description          | Example Response          |
|------|----------------------|---------------------------|
| 404  |Not Found.  | "error", "No owner found with that ID.." |

---

### **Delete a Owner**
- **URL:** `/api/owner/<id>/`
- **Method:** `DELETE`
- **Requires Authentication:** Yes
- **Description:** Deletes a specific resource associated with the authenticated user.


##### **Successful Response (204 No Content):**

```json
{
	"message": "Successfully deleted."
}
```
##### **Errors:**
| Code | Description          | Example Response          |
|------|----------------------|---------------------------|
| 404  | Not Found.  					| "error", "No owner found with that ID.." |

---


