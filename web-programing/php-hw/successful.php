<?php
    session_start();
    require_once("./storage.inc.php");
    require_once("./auth.inc.php");
    $userStorage = new Storage(new JsonIO("./data/users.json"));
    $auth = new Auth($userStorage);
    $errors = [];
    $auth -> Modify_taken($auth->authenticated_user()["username"]);
    require_once("header.php");


    //var_dump($auth->authenticated_user());
?>
<h1>Successful</h1>
<br>
<p>You have successfully booked!</p>
<a href="index.php" class="btn btn-primary">View my appointment</a>

<?php require_once("footer.php")?>