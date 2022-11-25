Implemented for the polling system:

The poll includes several questions. Each question can have multiple answers. Each answer option has a weight. There can be several results for each poll, depending on the number of points scored by the user during the survey.
The result of the poll includes the corresponding range of scores and decoding. To determine the result, the system must sum the weights for each user response.Implemented functionality allowing the user to take one survey no more than once a week. 
If less than a week has passed since the last pass, the result of the last pass is shown to the user.

In application there are` 
Java 
I18n
bean validation
exception handing
loggers(slf4j)
JPA

The application has 7 pages:
1.Login page 
2.Registration page
3.Home page where information about user and poll button
4.List of polls
5.Page taking a poll
6.Results
7. Error page
