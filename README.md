# Spring Demo - Petstore

This is a demo REST-API for a petstore using the sample server by [Swagger](https://petstore.swagger.io/). It has several end-points which have their own RestControllers.

##PET - Everything about your Pets

 ###POST 
`/pet` Add a new pet to the store
 
 Example of pet in body:
     <pre><code>    {
       "id": 0,
       "category": {
           "id": 5,
           "name": "Dog"
       },
       "name": "doggie",
       "photoUrls": [
           "http://dummyimage.com/227x100.png/ff4444/ffffff",
           "http://dummyimage.com/242x100.png/cc0000/ffffff"
       ],
       "tags": [
           {
               "id": 18,
               "name": "male"
            },
           {
               "id": 25,
               "name": "junior"
            }
       ],
       "status": "AVAILABLE"
     }</code></pre>


 ###PUT 
`/pet` Update an existing pet
 
 Example of pet in body:
 <pre><code>    {
       "id": 87,
       "category": {
           "id": 5,
           "name": "Dog"
       },
       "name": "doggie",
       "photoUrls": [
           "http://dummyimage.com/227x100.png/ff4444/ffffff",
           "http://dummyimage.com/242x100.png/cc0000/ffffff"
       ],
       "tags": [
           {
               "id": 18,
               "name": "male"
            },
           {
               "id": 25,
               "name": "junior"
            }
       ],
       "status": "SOLD"
     }</code></pre>

 ###GET
`/pet/findByStatus` Finds Pets by status

 Example of Request URL:
 
 <pre><code>
    http://localhost:8080/pet/findByStatus?status=available&status=pending

</code></pre>

 ###GET
`/pet/findByTags` Finds Pets by tags

 Example of Request URL:
 
 <pre><code>
    http://localhost:8080/pet/findByTags?tags=safe%20with%20kids&tags=can%20be%20home%20alone

</code></pre>

 ###GET
`/pet/{petId}` Find pet by ID

 Example of Request URL:
 
 <pre><code>
    http://localhost:8080/pet/42

</code></pre>

 ###DELETE
`/pet/{petId}` Deletes a pet

 Example of Request URL:
 
 <pre><code>
    http://localhost:8080/pet/87

</code></pre>

###POST
`/pet/{petId}/uploadImage` Adds an image url

Example of url in body:

<pre><code>
    http://dummyimage.com/152x100.png/cc0000/ffffff

</code></pre>
***
## STORE - Access to Petstore orders

### GET
`/store/inventory` Returns a list of all pets

Example of Request URL:

<pre><code>
    http://localhost:8080/store/inventory

</code></pre>

### POST
`/store/order` Place an order for a pet

Example of order in body:
 <pre><code>    {
        "id": 0,
        "petId": 42,
        "quantity": 0,
        "shipDate": "2021-11-30T10:17:50.931Z",
        "status": "PLACED",
        "complete": false
    }</code></pre>

###GET
`/store/order/{orderId}` Find purchase order by ID

Example of Request URL:

<pre><code>
    http://localhost:8080/store/order/88

</code></pre>

###DELETE
`/store/order/{orderId}` Delete purchase order by ID

Example of Request URL:

<pre><code>
    http://localhost:8080/store/order/88

</code></pre>
***
## USER - Operations about user

###POST
`/user` Create user

Example of User in body:
 <pre><code>    {
      "id": 0,
      "username": "BabaYaga",
      "firstName": "John",
      "lastName": "Wick",
      "email": "sheerfuckingwill@thecontinental.org",
      "password": "*************",
      "phone": "315-194-6020",
      "userStatus": 1
    }</code></pre>

###POST
`/user/createWithArray`  Creates list of users with given input array

`/user/createWithList`  Creates list of users with given input array

Example of Users in body:
 <pre><code>    [
        {
          "id": 0,
          "username": "Rick_C-137",
          "firstName": "Rick",
          "lastName": "Sanchez",
          "email": "pickleRick@universe.web",
          "password": "*****************************",
          "phone": "420-557-0137",
          "userStatus": 69
        },
        {
          "id": 0,
          "username": "RealJedi",
          "firstName": "Luke",
          "lastName": "Skywalker",
          "email": "bluemilk@tatooine.net",
          "password": "*****",
          "phone": "333-321547-1230-0215",
          "userStatus": 0
        }
    ]</code></pre>

###GET
`/user/login`  Logs user into the system

Example of Request URL:

<pre><code>
    http://localhost:8080/user/login?username=speiser20&password=DWj3zSxs

</code></pre>

###GET
`/user/logout` Logs out current logged in user session

Example of Request URL:

<pre><code>
    http://localhost:8080/user/logout

</code></pre>

###GET
`/user/{username}` Get user by username

Example of Request URL:

<pre><code>
    http://localhost:8080/user/BabaYaga

</code></pre>

###PUT
`/user/{username}` Update user
 <pre><code>    {
      "id": 86,
      "username": "dambresin2j",
      "firstName": "Dominic",
      "lastName": "Ambresin",
      "email": "dambresin2j@mapy.cz",
      "password": "kGNuOD8KbfkX",
      "phone": "4026787964",
      "userStatus": 666
    }</code></pre>

###DELETE
`/user/{username}` Delete user

Example of Request URL:

<pre><code>
    http://localhost:8080/user/RealJedi

</code></pre>
