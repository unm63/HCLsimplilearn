<!DOCTYPE html>
<html>
<head>

</head>

<body>

<h2>Feedback Test Form</h2>

<form name = "testform" action = "/feedback" method = "post">
  <label for="fname">Name:</label><br>
  <input type="text" id="user" name="user" ><br>
  <label for="comment">Comment:</label><br>
  <input type="text" id="comments" name="comments" ><br>
  <label for="rating">Rating:</label><br>
  <input type="text" id="rating" name="rating" ><br><br>
  <input type="submit" value="Submit" >
</form> 

<p>If you click the "Submit" button, the form-data will be sent to a page called "/action_page.php".</p>

</body>
</html>