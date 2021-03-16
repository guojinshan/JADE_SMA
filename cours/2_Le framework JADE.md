# Le framework JADE
Ce contenu correspond au cours du 20 février 2018.

JADE (Java Agent DEvelopment Framework) est une plateforme de développement de systèmes multi-agents implémentée en Java.

L'utilisation d'une telle plateforme permet de se concentrer sur la communication entre agents, en s'abstrayant des concepts logistiques inhérents.

## Introduction

### Conteneur d'agents

JADE apporte la notion de *conteneur d'agents*, c'est-à-dire un environnement qui contient plusieurs agents. On peut regrouper des conteneurs dans des *plateformes*.

On préférera mettre nos agents personnalisés dans un conteneur différent du *main container* de JADE.

### Agents système

Chaque conteneur d'agents dispose de deux agents système *AMS* et *DF* .

L'agent AMS (Agent Management System) assure le service de nommage (chaque agent a un nom unique l'identifiant), ainsi que la création et la suppression des agents.

L'agent DF (Directory Facilitator) assure le service des pages jaunes en répertoriant l'emplacement des différents agents.

## Cycle de vie d'un agent

### Initialisation

#### setup()

Une fois créé dans un conteneur, un agent est initialisé. La méthode setup() est appelée après sa création; elle sert à initialiser un agent.

Cette méthode est à surcharger, et est exécutée après la création de l'agent.

### Comportement d'un agent

### Tâche d'un agent

Chaque classe `Behaviour` doit implémenter la méthode `action()` qui définit la suite des instructions données pour chaque agent.

### Organisation du SMA

Chaque agent est exécuté dans un seul thread.

L'exécution des threads Java dans la JVM (*Java Virtual Machine*) est préemptive, c'est-à-dire qu'un certain temps est alloué par la JVM à chaque thread qui exécute des instructions, puis la JVM passe au thread suivant et ainsi de suite tant que les threads sont actifs. Cela donne ainsi un comportement similaire à une exécution en parallèle des threads.

### Avantages

- Un seul thread Java par agent.
- Élimination des problèmes de synchronisation lors d'accès aux mêmes ressources.
- Meilleures performances, car changer de `Behaviour` est plus rapide que de changer de thread dans la JVM.

## Communication entre agents

### Messages

Cette section contient essentiellement des exemples de code. Les extraits pertinents seront à ajouter et expliquer depuis les slides de cours quand les accès au Moodle seront disponibles.

### One-shot Behaviour
Il s'agit d'un comportement spécifique, pour lequel la méthode `action()` n'est exécutée qu'une seule fois. La classe behaviour doit étendre `OneShotBehaviour`.

### Cyclic behaviour
La méthode `action()` exécute les mêmes instructions chaque fois qu'elle est appelée. La tâche n'est jamais terminée. La classe behaviour doit étendre `CyclicBehaviour`.
La méthode `done()` est déjà implémentée et retourne `false()`.

## Glossaire

- AMS : Agent Management System
- DF : Directory Facilitator
- JADE : Java Agent DEvelopment Framework
- JVM : Java Virtual Machine
- SMA : Système multi-agents

## Liens utiles

- Le site du framework JADE : http://jade.tilab.com
- La Javadoc du framework JADE : http://jade.tilab.com/doc/api/index.html
- Comparaison de différentes plateformes de SMA : http://jasss.soc.surrey.ac.uk/18/1/11.html
