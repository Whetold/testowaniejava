Given Messenger app
When check connection with proper adress name rebel.pl
Then result equals 0 is returned

When check connection with .com ending name rebel.com
Then result equals 0 is returned

When send message dasdasdasdasdas with server rebel.pl not successfully
Then result equals 1 is returned