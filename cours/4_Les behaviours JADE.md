# Les behaviours JADE

## Behaviours prédéfinis

### Behaviours simples

- **OneShotBehaviour** : modélise les behaviours atomiques qui ne sont exécutés qu’une seule fois et qui ne peuvent pas être bloqués. La méthode `done()` retourne toujours true.

- **CyclicBehaviour** : modélise les behaviours atomiques qui s’exécutent indéfiniment. La méthode done() retourne toujours false.

- **WakerBehaviour** : modélise les behaviours atomiqes qui ne sont exécutés qu'une seule fois mais après un certain délai.

- **TickerBehaviour** : modélise les behaviours atomiques qui s'exécutent indéfiniment mais à intervalles réguliers.


### Behaviours composites

- **CompositeBehaviour** : la classe de base des behaviours composites.

- **SequentialBehaviour** : exécute ses sous-behaviours de façon séquentielle et se termine lorsque le dernier est exécuté. On peut utiliser cette classe lorsqu’une tâche complexe se décompose en une suite de tâches.

- **ParallelBehaviour** : exécute ses sous-behaviours de façon concurrente et se termine lorsque soit :
  - tous ses sous-behaviours sont terminés,
  - l’un quelconque de ses sous-behaviours est terminé, • n de ses sous-behaviours sont terminés.

### Machine à états

**FSMBehaviour** : exécute ses sous-behaviours selon une machine à états finis définie par l’utilisateur.

Chaque sous-behaviour représente l’activity exécutée dans un état de l’automate.

- Lorsque le sous-behaviour correspond à un état se termine, sa valeur de terminaison (retournée par la méthode `onEnd()` est utilisée pour déterminer la transition et atteindre le prochain état exécuté au prochain tour.

- Certains sous-behaviours sont marqués comme états finals.
- Le FSMBehaviour se termine après terminaison de l’un des sous-behaviours état final.

## Behaviours utiles

### Initiateur simple

L'initiateur simple est un behaviour qui envoie un message, et qui attend une réponse à ce message - peu importe le type de la réponse.

- Le message est envoyé dans le constructeur du behaviour.
- Paramètres : l’agent et le message à envoyer.
- Fonctionnement : déclenche la méthode handleResponse lorsque le message de réponse est parvenu.
- Le behaviour s’arrête lorsque un message est reçu.
- Classe abstraite ; la méthode `handleResponse` doit être surchargée.

#### Implémentation

```java
public abstract class BaseInitiatorBehaviour extends Behaviour {
  boolean over = false;
  MessageTemplate mt;

  public BaseInitiatorBehaviour(Agent a, ACLMessage message) {
    super(a);
    String id = UUID.randomUUID().toString();
    mt = MessageTemplate.MatchConversationId(id);
    message.setConversationId(id);
    myAgent.send(message);
  }

  protected abstract void handleResponse(ACLMessage message) ;

  @Override
  public void action() {
    ACLMessage response = myAgent.receive(mt);
    if (response != null) {
      handleResponse(response);
      over = true;
    }
    else block();
  }

  @Override
  public boolean done() {
    return over;
  }
}
```

### Initiateur CONFIRM REFUSE

L'initiateur CONFIRM REFUSE est un behaviour qui envoie un message et qui attend une réponse à ce message - peu importe le type du message.

- Le message est envoyé dans le constructeur du behaviour.
- Paramètres : l’agent et le message à envoyer.
- Fonctionnement : déclenche la méthode :
  - handleConfirm lorsque une réponse `Confirm` est parvenue.
  - handleRefuse lorsque une réponse `Refuse` est parvenue.
  - handleOther lorsque une autre réponse est parvenue.
- Le behaviour s’arrête lorsque un message est reçu.
- Une des méthodes doit être surchargée.

On peut utiliser cet initiateur pour le calcul d'une factorielle

#### Implémentation

```java
public class InitiatorBehaviour extends BaseInitiatorBehaviour {
  public InitiatorBehaviour(Agent a, ACLMessage message) {
    super(a, message);  
  }
  protected void handleConfirm(ACLMessage response) {}
  protected void handleRefuse(ACLMessage response) {}
  protected void handleOther(ACLMessage response) {}

  @Override
  public void handleResponse(ACLMessage response) {
    if (response.getPerformative() == ACLMessage.CONFIRM)
      handleConfirm(response);
    else if (response.getPerformative() == ACLMessage.REFU
      handleRefuse(response);
    else
      handleOther(response);
  }
}
```

### Initiateur à durée limitée

Il s'agit d'un behaviour qui envoie un message et qui attend une réponse à ce message pendant une durée limitée - peu importe le type du message.

- Le message est envoyé dans le constructeur du behaviour.
- Paramètres : l’agent, le message à envoyer et la durée.
- Fonctionnement : déclenche la méthode handleAnswer lorsque un message de réponse est parvenu et handleEmpty lorsque la durée d’attente est écoulée sans message.
- Le behaviour s’arrête lorsque un message est reçu ou lorsque la durée est atteinte.
- Les méthodes handleAnswer et handleEmpty doivent être surchargées.

#### Implémentation

```java
public abstract class DelayBehaviour extends Behaviour {
  int maxDelay;
  long initTime;
  MessageTemplate mt;
  boolean over = false;

  public DelayBehaviour(Agent a, ACLMessage message, int maxDelay) {
    super(a);
    this.maxDelay = maxDelay;
    initTime = System.currentTimeMillis();
    String id = UUID.randomUUID().toString();
    mt = MessageTemplate.MatchConversationId(id);
    message.setConversationId(id);
    myAgent.send(message);
  }

  protected abstract void handleAnswer(ACLMessage response();
  protected abstract void handleEmpty();

  @Override
  public void action() {
    long currentTime = System.currentTimeMillis();
    ACLMessage response = myAgent.receive(mt);
    if (response != null) {
      handleAnswer(response); over = true;
    } else if (currentTime - initTime > maxDelay) {
      handleEmpty(); over = true;
    }
  }

  @Override
  public boolean done() {
    return over;
  }
}
```

### AchieveREInitiator

JADE fournit la classe **AchieveREInitiator** pour les behaviours d’envoi et d’attente de message.
- La classe fournit les méthodes handleInform, handleRefuse, handleAgree, handleNotUnderstood.
- Ces méthodes sont déclenchées en fonction du performatif du message reçu.
- Il est nécessaire de surcharger les méthodes désirées.
