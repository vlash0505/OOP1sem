<h1>Organizer app</h1>

App that helps its users to organize their time in one place.

An attempt was made to keep to MVC pattern. 
DAO pattern is used for persistence mechanism for storing users, goals tasks and notes.

Functionality of the app includes planning, goal setting, journaling, countdown timer and achievements collecting.
<br>
<br>
Login window view: ![Screenshot 2022-01-21 144253](https://user-images.githubusercontent.com/87067491/150536315-dc3de050-e5a4-4bed-8489-169f345bdb82.png)
<br>
<br>
In a came of wrong input (user does not exist in a database), status bar gives user an error message: ![Screenshot 2022-01-21 144619](https://user-images.githubusercontent.com/87067491/150536539-213e2e48-f066-4f5c-9098-87e4466bbc6b.png)
<br>
<br>
Signup window view: ![Screenshot 2022-01-21 144314](https://user-images.githubusercontent.com/87067491/150536362-e7995496-8aae-4584-9ab4-7474f562eab9.png)
<br>
<br>
In a case when user with specified email or username already exists or input fields does not succeeded in regular expression validation, status bar gives an error message: ![Screenshot 2022-01-21 144639](https://user-images.githubusercontent.com/87067491/150536776-72025db7-eea4-4080-95bf-0fa24aeb3a6f.png)
<br>
<br>
Home view: when the user signed in, first thing he/she sees is the plan for today(loaded from the database by the current date) ![Screenshot 2022-01-21 144855](https://user-images.githubusercontent.com/87067491/150537106-6496aecc-05ff-4492-a278-39e1c4b4a076.png)
<br>
<br>
In a plan section user can plan out selected day using the date picker. ![Screenshot 2022-01-21 144916](https://user-images.githubusercontent.com/87067491/150537285-2b516e09-2183-4b3d-9fde-3d9cea847e5c.png)
<br>
<br>
When user adds a task, custom input pane appears(with constrains, text should be from 1 to 44 characters) ![Screenshot 2022-01-21 144951](https://user-images.githubusercontent.com/87067491/150537462-0c0241c2-8a40-4b8f-a593-a573f7ebf6a0.png)
<br>
<br>
User has three types of goals he/she can easily switch between.![Screenshot 2022-01-21 145931](https://user-images.githubusercontent.com/87067491/150537712-83815dc7-4c99-479e-affa-ccbdeea8e13c.png)
<br>
![Screenshot 2022-01-21 150045](https://user-images.githubusercontent.com/87067491/150537774-7aca3f96-bdd2-4f75-ae6e-4d1667e4f80f.png)
<br>
When the goal is marked completed, it goes to the bottom of VBox and than appears as a text in achievements VBox of the corresponding with the goal task<br>![Screenshot 2022-01-21 150106](https://user-images.githubusercontent.com/87067491/150537962-0254273a-afbe-4054-be22-20fc6c093a65.png)
<br>
<br>
The same as with tasks, when user wants to create a goal, custom input pane with constraints appears <br>![Screenshot 2022-01-21 145906](https://user-images.githubusercontent.com/87067491/150538287-36ca1931-6571-4e34-bbb1-37da63bc7879.png)
<br>
<br>
App also has a timer function <br> ![Screenshot 2022-01-21 150142](https://user-images.githubusercontent.com/87067491/150538392-26db24a5-eafb-4ebb-bc1d-236f96b3b58a.png)
<br>
<br>
Journaling functionality includes taking notes corresponding with the choosen date.<br>![Screenshot 2022-01-21 150251](https://user-images.githubusercontent.com/87067491/150538627-9f310640-33d7-47b8-809c-2f9f3b88dfe9.png)
<br>
<br>
User can pick date from date picker, if there is already a note, it will be loaded from the database, otherwise, empty text field will appear, to save a note, user has to press "update notes" button
<br>
![Screenshot 2022-01-21 150305](https://user-images.githubusercontent.com/87067491/150538906-1a9f99d1-a368-49d9-911f-898edfedfa8a.png)
<br>
<br>
And the final section is achievements, where completed goals are stored.![Screenshot 2022-01-21 150328](https://user-images.githubusercontent.com/87067491/150539013-38a70be1-48b6-4f07-9efe-6d35b7fa094c.png)


