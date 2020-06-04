# recommendation-of-new-friends
# Introduction:
One of the main functionalities offered by online social platforms such as Facebook and Twitter is the recommendation of new friends.
This is achieved by utilizing various information about the users, but the main factor used for recommending a new friend to a user is how well these
two users are connected.
A social network such as Facebook can be represented as undirected graph. We can use the information contained in the graph to select the top candidate friends for a given user.
There are many ways to do this, but we will focus on two methods:

1. Popular users: In this method, we recommend the most popular users in the graph,that is nodes with the highest degrees (number of neighbors).

2. Common neighbors: In this method, we recommend users who have the most common friends with the user.
