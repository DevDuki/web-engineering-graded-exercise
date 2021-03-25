# WebEngineering Module, Graded Exercise

## Commit Proposal

Matriculation Number: 18-461-483

Project idea short description: 
Meine Idee ist eine Todo Web Applikation mit Spring Boot zu erstellen. Da ich bereits eine ähnliche Applikation mit Javascript und localstorage gebaut habe, würde ich gerne nun eine Applikation auf Basis von Java mit dem Spring Framework erstellen, um den Unterschied anschauen zu können. Die App soll standard funktionen wie das hinzufügen, löschen und bearbeiten eines Todos ermöglichen, sowie auch ein angenehmes Interface anbieten. 


## Project confirmation

Eine Todo Web Applikation ist in der Tat der Klassiker zum Vergleich verschiedener Frontendtechnologien. Das geht natürlich immer. 🙂 Wenn am Ende noch Zeit übrig ist, kann die Applikation auch noch gut erweitert werden, beispielsweise mit einem Login und Aufgaben, die den Benutzern zugewiesen werden.

Sie können anfangen. Viel Erfolg!


## Project delivery <to be filled by student>

How to start the project: (if other than `./mvnw spring-boot:run`) Sollte noch immer gleich sein, zumindest habe ich da nichts herumgeschraubt. :)

How to test the project:  (if other than `./mvnw verify`) Ich habe immer "mvn test" im Terminal ausgeführt, um die Tests durhczuführen.

Hand-written, static HTML 
project description:      (if other than `index.html` in project root directory)

External contributions: stackoverflow war immer irgendwie dabei :D und das Projekt Contact List, aus der Vorlesung, hat als Vorlage gedient.

Other comments: 
Da ich mich zukünftlich in Richtung WebDev orientieren möchte, war dieses Projekt besonders spannend für mich. Ich habe bereits ein paar kleinere eher Frontendlastige und nur ein bisschen Backendbasierte WebApplikation mit JavaScript erstellt, jedoch noch nie mit SpringBoot. Es war sehr lehrreich und interessant die Unterschiede dieser zwei Vorgehensweisen zu entdecken. 

Anfangs war es seeeehr frustrierend irgendwo überhaupt anzufangen, doch nach einer Weile kommt man in den flow und dann ging es mehrheitlich recht gut. (Ausser bei den Tests, weil irgendwie meine Test Klassen, die Starterklasse nicht finden konnte und ich Stundenlang nach dem Fehler suchen musste, dabei hat es nur an der Projektstruktur gelegen, aber immerhin funktionieren die Tests jetzt)

Mein Fazit: 
Ich hab mich einfach in JavaScript verliebt und werde mich deswegen auch Zukünftlich weiterhin damit befassen, dennoch finde ich es wichtig andere Frameworks ausprobiert zu haben, um ein besseres Gefühl und Verständnis für WebApplikationen im Allgemeinem zu erhalten. 

Hat mir sehr viel Spass gemacht und konnte viel neues erlernen! :D

PS: Kleiner Notiz am rande. Bei den Commits habe ich bemerkt, dass da von zwei verschiedenen Accounts gepusht wurde (Dukiking & DevDuki). Dukiking ist mein Account, welches ich extra für die FHNW erstellt habe und DevDuki is mein privater Account. Irgendwie haben sich diese nun vermischt, da ich über die Zeitspanne bei beiden Accounts an verschiedenen Projekte gearbeitet habe und irgendwie kann man im IntelliJ mit beiden accounts pushen, ohne einen Error zu bekommen. Hab dies leider erst am Ende bemerkt.

I'm particular proud of:
Am meisten stolz bin ich auf die endlich erfolgreich laufenden Tests und auf das Design meiner Todo App. Ich habe auch extra viel Zeit ins Frontend investiert, da meiner Meinung nach auch das Aussehen einer Applikation heutzutage immer wichtiger ist. 

Generell bin ich stolz drauf, dass ich zum ersten Mal eine komplette Fullstack (vom Front- bis zum Backend UND Tests) WebApplikation erstellen konnte.


## Project grading 

Die Datei index.html ist vorhanden, gut ausgearbeitet und besteht aus validem HTML.

Die Applikation funktioniert.

Sie haben eine Todo-Webapplikation mit einer Domainklasse, Input-Validierung, Custom-Styling und Security geschrieben.

Input-Validierung findet sowohl client- als auch serverseitig statt.

Die Anwendung ist geschützt und Benutzer können nur auf ihre Daten zugreifen. Ein Rollenkonzept gibt es aber nicht.

Die Einträge im Commit Log sehen gut aus, das Log ist aber recht kurz. Sie hätten häufiger Zwischenstände committen können. Das erleichtert später das Nachvollziehen der umgesetzten Lösung und erlaubt einem auch immer, zu einem funktionierenden Zwischenstand zurückzugehen, falls man sich verrennt.

Die Tests sind sauber geschrieben und ausführlich. Es gibt Integrationstests und e2e-Tests. Idealerweise hätten Sie noch Modifikationen in den Integrationstests und Spezialfälle (wie ungültige Eingabeparameter) getestet.

Das generierte HTML enthält Fehler, z.B.
* `Error: Duplicate ID update-status.`
* `Error: Duplicate ID delete-todo.`
* `Error: Attribute gucken not allowed on element button at this point.`
Letzteres ist ein Folgefehler, weil beim Value-Attribut keine Anführungszeichen genutzt werden.

Kommentare sind gut geschrieben. Idealerweise hätten Sie sie aber als JavaDocs verfasst.

Die Namensgebung ist gut und Sie beachten die Java-Namenskonventionen. Es gibt kaum Code-Duplizierung.

Extrapunkte habe ich für das ansprechende Design vergeben.

Herzlichen Glückwunsch!
Sie haben in einem recht knappen Zeitrahmen eine voll funktionierende, verteilte, interaktive Mehrbenutzerapplikation erstellt inklusive einer Datenbankanbindung und ausgiebiger Tests.
Damit haben Sie solide Kenntnisse von WebMVC und Engineering-Praktiken gezeigt.

Grade: 5.9
