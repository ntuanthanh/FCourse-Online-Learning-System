# Fcourse Online Learning Systems
# About : 
   ### * Description : 
   This project is aimed at developing an online learning system which supports for the organization/expert to build up & sell the online courses, 
   supports the user to search-registerand-access online course for learning. This system support for the below types of user
   - Guest: unregistered users
   - Customer: they are registered users who are actual customers or potential customers
   - Marketing: the marketing members of the organization
   - Sale: the sale members of the organization
   - Expert: access & prepare the course/test contents as assigned by admin
   - Admin: the organization leader/manager, acts as the system administrator
   ### * Role/Main Tasks : Member/Backend( Must complete all requirements assigned ( backend and fontend of Requirement )  )
   ### * Languages programing, libraries and frameworks : 
  - Java, JavaScript, Html, Css, Boostrap, Jquery, Ajax
# My features are assigned: 
## 1. User Profile
 * Requirement: This is a pop-up screen which allows the user to edit his/her profile information, including the registered ones & the avatar image. 
Please note that s/he is not allowed to change the email
#### 1.1 Screen user profile
![1  User Profile](https://user-images.githubusercontent.com/99120557/178021463-53bb11e0-d219-46dd-a760-ad8b422e09e5.JPG)
#### 1.2 Pop-up screen which allows the user to edit his/her profile information
![2 UserProfile](https://user-images.githubusercontent.com/99120557/178022762-e70fbe17-2ba3-4ee7-8b01-1f4af6759ace.JPG)
## 2. Reset Password
 * Requirement: 
 The user to input his/her email to receive the reset password link. This link is sent to the user's email for his/her password resetting. 
 On clicking the link, the user is redirected to the password resetting page in which s/he input new password (twice) for the system access.
 Note that the link is only available for a specific time duration as configured in the system config file. 
#### 2.1 The user to input his/her email to receive the reset password link.
![3 Reset Password](https://user-images.githubusercontent.com/99120557/178027005-47cb2318-bd9f-40c7-86b6-c9e3659df71a.JPG)
#### 2.2 This link is sent to the user's email for his/her password resetting.( Using Java Mail )
- The link is only available for a specific time duration as configured in the system config file.
![4 Reset Password](https://user-images.githubusercontent.com/99120557/178027299-66dda9a7-ba8e-41ff-ab9f-165b5dca3a82.JPG)
- Check mail:
![5](https://user-images.githubusercontent.com/99120557/178027700-651c5798-2cc6-4251-ad56-7afa904ad233.JPG)
- After click the link to reset password: 
![image](https://user-images.githubusercontent.com/99120557/178028003-e1daeb17-197b-4057-872b-5d7d2f87d184.png)
 - After reset password successfull click link again or link time out can't reset password by this link
 ![image](https://user-images.githubusercontent.com/99120557/178028553-dc9460b2-7810-49ae-9350-36f2c7e15937.png)
## 3. Subject Details ( using ajax )
 * Requirement: 
 This page allows the admin and the assigned expert to access and prepare the subject information, including the course general information, 
 the dimension, and price package. Only the admin can change the status to Published or Unpublished + add/edit the price packages
![image](https://user-images.githubusercontent.com/99120557/178029457-e21f7038-5320-4df6-8b6b-c959ca9be37d.png)
![image](https://user-images.githubusercontent.com/99120557/178033502-30d4f688-7a1c-4ace-b61e-58326d98f98c.png)
## 4. Subject Price Package ( using ajax )
 * Requirement:
 This page allows the admin and the assigned expert to access and prepare the subject information, including the course general information, 
 the dimension, and price package. Only the admin can change the status to Published or Unpublished + add/edit the price packages
#### 4.1 Show price packages of this course ( Can change status of this price package this screen )
![image](https://user-images.githubusercontent.com/99120557/178030384-7308fad7-fc92-4f04-bc8f-7d574efd61b2.png)
![image](https://user-images.githubusercontent.com/99120557/178033630-c6bc76f8-c0b6-459a-8e1e-f06a740d5cb9.png)
#### 4.2 Add - Edit price packages of this course
![image](https://user-images.githubusercontent.com/99120557/178030748-392b0ffe-2f20-47db-8634-6c40f7148608.png)
## 5. Subject Dimension ( using ajax )
* Requirement: 
 This page allows the admin to input or edit subject dimension information, 
 including the following detailed information: name, access duration (in months), status (read-only), list price, sale price, description. 
 The expert can only view the information.
![image](https://user-images.githubusercontent.com/99120557/178031363-e1f466e5-6260-4755-a132-4f85e77d5b58.png)
## 6. Registrations List ( Advanced Search, Sort and Paging ) 
* Requiremet: 
Show the list of users' registrations
- Each registration includes below information: id, email, registration time, subject,  package, total cost, status, valid from, valid to, last updated by;
- The user can filter the list by subject (searchable), registration time (from, to), status + can search by the email
- The list can be sorted by id, email, registration time, subject, package, total cost, status, valid from, valid to
![image](https://user-images.githubusercontent.com/99120557/178031815-e9866958-0f90-477d-b950-65b9506e0345.png)
![image](https://user-images.githubusercontent.com/99120557/178032291-a4bb387f-0077-4083-a8ea-25553e1a0726.png)
## 7. Lesson View ( In Progressing ) 
( Reference font end by Coursera - https://www.coursera.org/ )
* Requirement: 
Allow customer to access the course lessons for his/her studying
![image](https://user-images.githubusercontent.com/99120557/180927142-3f95a427-5556-4b67-917b-39cff921411b.png)
![image](https://user-images.githubusercontent.com/99120557/180927210-9dee4d95-f11b-4654-8655-f4d7781304e6.png)
![image](https://user-images.githubusercontent.com/99120557/180927331-bbb39090-b49c-429a-87cd-80154208f933.png)
![image](https://user-images.githubusercontent.com/99120557/180927444-0abf6cbd-bc79-440a-8c6a-0779b12908e9.png)

