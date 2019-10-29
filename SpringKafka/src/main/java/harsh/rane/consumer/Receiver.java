package harsh.rane.consumer;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.kafka.annotation.KafkaListener;

@ConditionalOnMissingBean(name = "kafkaListenerContainerFactory")
public class Receiver {
	
		  private CountDownLatch latch = new CountDownLatch(1);

		  public CountDownLatch getLatch() {
		  return latch;
		  }

		  @KafkaListener(topics = "helloworld.t")
		  public void receive(int payload) {
		 // LOGGER.info("received payload='{}'", payload);
			System.err.println("CONSUMED DATA "+payload);
		    latch.countDown();
		    
		  }
}
