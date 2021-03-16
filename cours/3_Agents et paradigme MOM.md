# Le paradigme MOM
Ce contenu correspond au cours du 5 mars 2018.

## Introduction

- Message-Oriented Middleware (MOM) : communication asynchrone et persistante.
- Chaque entité peut envoyer et recevoir des messages.
- Les messages sont envoyés une fois au destinataires (1 à 1 ou 1 à plusieurs).

2 possibilités :
- Message intercepté
- Message a réussi à passer

L'expéditeur n'a pas moyen de savoir si le message est bien arrivé.
Dans le cas de l'envoi de 2 messages, on n'est pas sûrs que le premier arrive avant le deuxième.

## Définition d'un agent
Un agent est un système informatique :
- situé dans un environnement,
- qui agit d'une façon autonome et flexible pour atteindre les objectifs pour lesquels il a été conçu.

Un agent est capable d'agir sans l'intervention directe d'un humain ou d'un autre agent, et a le contrôle de ses actions et de son état interne.


### Compétence
Un agent est capable de faire un certain nombre de choses, de rendre un certain nombre de services : ce sont ses compétences.

Une compétence se traduit par les tâches, les actions, les raisonnements que l'agent peut entreprendre pour mettre en œuvre cette compétence.

Il peut être intéressant d'indiquer à d'autres entités les compétences d'un agent.

### Action
Une méthode, un truc que fait un agent. Ex: parser un fichier, avancer dans un espace...
### Tâche
Un agent est programmé pour exécuter des tâches.
### But
Un agent peut devoir atteindre un but (maximioser une fonction d'utilité, atteindre une certaine situation...) <br>
L'agent peut utiliser un système expert, ou établir un plan de la suite de tâches pour atteindre un but.
### Monde
L'environnement dans lequel l'agent est situé. <br>
Un agent peut se construire une rpz interne du monde. L'agent doit également avoir des infos sur la manière dont ses actions affectent le monde autour de lui (ex. Pour qu'un agent puisse ouvrir une porte, il faut que cette porte soit fermée).

## Approche agent - 1
Un _AgentMathFactorielle_ implémente aussi le calcul de factorielle.

L'agent contrôle son comportement : il peut ignorer un msg à partir d'un entier négatif par exemple.

## Approche agent - 2
g pa suivi lol

## Trois types d'agent
- Agents reactifs -> Réagit aux changements qui surviennent dans l'environnement.
- Agents deliberatifs -> planification / raisonnement est mis en place. Deep learning toussa toussa.
- Agent hybrides -> Reconnaissent s'ils sont dans une situation d'urgence ou pas et agissent en conséquence. Majorité des problèmes nécessitent cette approche.

### Architecture hybride
- Une couche purement réactive basant ses actions sur les données brutes des capteurs
- Une couche intermédiaire qui travaille avec une vision au niveau des connaissances de l'environnement
- Une couche supérieure qui se charge des aspects sociaux - > Contact avec les autres agents
