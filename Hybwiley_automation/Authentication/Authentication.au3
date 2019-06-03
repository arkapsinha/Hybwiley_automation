
$society = $cmdLine[1]

$username = $cmdLine[2]

$password = $cmdLine[3]

Sleep(10000)

WinWaitActive($society)

While WinExists($society)

Send($username)
Send("{TAB}")
Send($password)
Send("{ENTER}")
Sleep(5000)

WEnd