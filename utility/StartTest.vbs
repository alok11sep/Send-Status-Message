TOlist = "alok@a.com;alok@a.com;"
CC = "alok@a.com;alok@a.com;"
BCC = "alok@a.com;alok@a.com;"
SUBJ = "[ISA]:TaskName"
MsgTemplate="D:\Alok\templates_benches\templates_benches\HTIS5-Benches-TEMPLATE-Issue-TBV.oft"
Set Outlook = CreateObject("Outlook.Application")
Set MAPI = Outlook.GetNameSpace("MAPI")
Set NewMail = Outlook.CreateItemFromTemplate(MsgTemplate)
NewMail.Subject = SUBJ
NewMail.TO = TOlist
NewMail.CC = CC
NewMail.BCC = BCC
NewMail.display