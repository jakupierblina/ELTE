
# Hotel Booking System



<img src="Screenshot 2021-01-23 210244.png">

****

## Tasks

### List page

- On the *list page* (a.k.a. the *main page*) a static title and a short introduction should be visible.
- Users who are not logged in are free to browse the available times and availability data (see below).
- The booking contains a few pieces of data: on what day, at what time, how many people can come for a vaccine.
- The available dates in the given month should be listed on the *list page* in the format of "day, date, free slots / total slots" (eg 2021.01.22 15:00 3/5 free slots).
- Free appointments should be green (with text, background, frame or other style markings), already filled dates should be red.
- There should be two links below the table: one to list the previous month and the other to list the next month.
- There should be a "Book this date" link at each time.
- If you are not logged in, clicking on "Book this date" will take you to the login page.

### Authentication pages

- It should be possible to access the login and registration page from the main page.

- **During registration** an user must enter their full name, SSN number (social security number), address, email address and their password twice.

  - Full name: required
  - SSN number: required, 9 characters long, consists of numbers only, e.g. 123456789
  - address: required
  - e-mail: required, unique for each user, email format
  - Password: required
  - Password confirmation: required, must match the password

  In case of an error, display  appropriate error messages! The form must be persistent, so after an  error, previously filled data should remain in the form. After a  successful registration, go to the login page!

- On the **login page** users can identify themselves with their e-mail address and password:

  - e-mail: required, unique, email format
  - Password: required

  If there was an error logging in,  display a message about it above the login form! After successful login, redirect the user to the **list page**!

### Details of booking a date

- After logging in, clicking on the  "Book this date" button will take the user to the page detailing the  given time. Here the site must display the date, time, and the logged in user's data (name, address and SSN number), and a checkbox to accept  terms and conditions (eg that it is mandatory to show up on the  appointment after booking it, or that there may be side effects of  vaccination).
- Then, by clicking on the "Confirm"  button, the system will record the user's name for that time. If the  checkbox is not checked, display an error message on the page! After a  successful booking, the user will be taken to a separate page where the  system informs them that the booking was successful.

### If the user already has an appointment, ...

- ... the *list page*'s top should show the details of the booked date. Design this part to be extra noticeable!
- ... under the booked date, a button should show up, pressing which cancels the appointment and resets the *list page*.
- ... the "Book this date" link does not show up for dates in the list.

### Admin functions

- Have a special user,

   

  admin

   

  (email:

   

  admin@nemkovid.hu

  , password: admin), who can do two things:

  - At the bottom of the date details  page (where a user could apply), the admin sees a list of users who  applied for that date. (Show name, SSN, and email address!)

  - The *list page* contains a new "Post a new date" link. By clicking on it, the admin can add a  new available date (on a separate page, only accessible by the admin  user) with the following input data:

    - Date: required, valid date
    - Date: required, valid date
    - Total slots: required, number (How many people can apply for this date)

    Display all errors on the page! The  form must be persistent, so if an error occurs, the form should keep the input values. After the new date was added, redirect the browser to the *list page*..
