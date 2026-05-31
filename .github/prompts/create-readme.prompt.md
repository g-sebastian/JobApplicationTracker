sudo python3 - << 'PY'
import imaplib, email

EMAIL_ADDRESS = "baeckersebi@gmail.com"
EMAIL_APP_PW  = "GreimelS12022006"

with imaplib.IMAP4_SSL("imap.gmail.com") as m:
    m.login(EMAIL_ADDRESS, EMAIL_APP_PW)
    m.select("INBOX")
    _, msgs = m.search(None, 'SUBJECT "artemis-token"')
    print(f"Gefundene Emails: {len(msgs[0].split())}")
    for num in msgs[0].split()[-3:]:
        _, data = m.fetch(num, "(RFC822)")
        msg = email.message_from_bytes(data[0][1])
        print(f"  Betreff: {msg['subject']}, Gelesen: {'\\Seen' in str(m.fetch(num, '(FLAGS)'))}")
PY