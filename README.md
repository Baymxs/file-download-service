# Service for file downloading
A service that allows you to download files by id or by name.
If the client requests to download a file by id, then the file will be decoded from Base64 before sending.
If the client requests to download a file by name, the file will be sent without decoding.
# REST API Reference
## Response Codes
```
200: Success
404: Cannot be found
```
## Download file by id
---
#### Request URL:
`GET /api/v1/files/{id}`
#### Successful Response:
**Status:** `200`
```json
{
	Brave new world
}
```
#### Failed Response:
**Status:** `404`
```json
{
    "errorMessage":  "File with id [id] not found"
}
```
## Download file by name
---
#### Request URL:
`GET /api/v1/files/name/{name}`
#### Successful Response:
**Status:** `200`
```json
{
	Brave new world
}
```
#### Failed Response:
**Status:** `404`
```json
{
    "errorMessage":  "File with name [name] not found"
}
```
# License
MIT
----
> GitHub: [@baymxs](https://github.com/Baymxs) 
> VK: [@baymxs](https://vk.com/baymxs)
