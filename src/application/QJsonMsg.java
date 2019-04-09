package application;

import java.util.ArrayList;

class QJsonMsg {
	@Override
	public String toString() {
		return "QJsonMsg [consumers=" + consumers + ", message_bytes_ready=" + message_bytes_ready
				+ ", message_bytes_unacknowledged=" + message_bytes_unacknowledged + ", messages_unacknowledged="
				+ messages_unacknowledged + "]";
	}

	ArrayList<Object> consumer_details = new ArrayList<Object>();
	Arguments ArgumentsObject;
	private boolean auto_delete;
	Backing_queue_status Backing_queue_statusObject;
	private String consumer_utilisation = null;
	private int consumers;
	ArrayList<Object> deliveries = new ArrayList<Object>();
	private boolean durable;
	ArrayList<Object> effective_policy_definition = new ArrayList<Object>();
	private boolean exclusive;
	private String exclusive_consumer_tag = null;
	Garbage_collection Garbage_collectionObject;
	private String head_message_timestamp = null;
	private String idle_since;
	ArrayList<Object> incoming = new ArrayList<Object>();
	private float memory;
	private float message_bytes;
	private float message_bytes_paged_out;
	private float message_bytes_persistent;
	private float message_bytes_ram;
	private float message_bytes_ready;
	private float message_bytes_unacknowledged;
	Message_stats Message_statsObject;
	private float messages;
	Messages_details Messages_detailsObject;
	private float messages_paged_out;
	private float messages_persistent;
	private float messages_ram;
	private float messages_ready;
	Messages_ready_details Messages_ready_detailsObject;
	private float messages_ready_ram;
	private float messages_unacknowledged;
	Messages_unacknowledged_details Messages_unacknowledged_detailsObject;
	private float messages_unacknowledged_ram;
	private String name;
	private String node;
	private String operator_policy = null;
	private String policy = null;
	private String recoverable_slaves = null;
	private float reductions;
	Reductions_details Reductions_detailsObject;
	private String state;
	private String vhost;

	// Getter Methods

	public Arguments getArguments() {
		return ArgumentsObject;
	}

	public boolean getAuto_delete() {
		return auto_delete;
	}

	public Backing_queue_status getBacking_queue_status() {
		return Backing_queue_statusObject;
	}

	public String getConsumer_utilisation() {
		return consumer_utilisation;
	}

	public int getConsumers() {
		return consumers;
	}

	public boolean getDurable() {
		return durable;
	}

	public boolean getExclusive() {
		return exclusive;
	}

	public String getExclusive_consumer_tag() {
		return exclusive_consumer_tag;
	}

	public Garbage_collection getGarbage_collection() {
		return Garbage_collectionObject;
	}

	public String getHead_message_timestamp() {
		return head_message_timestamp;
	}

	public String getIdle_since() {
		return idle_since;
	}

	public float getMemory() {
		return memory;
	}

	public float getMessage_bytes() {
		return message_bytes;
	}

	public float getMessage_bytes_paged_out() {
		return message_bytes_paged_out;
	}

	public float getMessage_bytes_persistent() {
		return message_bytes_persistent;
	}

	public float getMessage_bytes_ram() {
		return message_bytes_ram;
	}

	public float getMessage_bytes_ready() {
		return message_bytes_ready;
	}

	public float getMessage_bytes_unacknowledged() {
		return message_bytes_unacknowledged;
	}

	public Message_stats getMessage_stats() {
		return Message_statsObject;
	}

	public float getMessages() {
		return messages;
	}

	public Messages_details getMessages_details() {
		return Messages_detailsObject;
	}

	public float getMessages_paged_out() {
		return messages_paged_out;
	}

	public float getMessages_persistent() {
		return messages_persistent;
	}

	public float getMessages_ram() {
		return messages_ram;
	}

	public float getMessages_ready() {
		return messages_ready;
	}

	public Messages_ready_details getMessages_ready_details() {
		return Messages_ready_detailsObject;
	}

	public float getMessages_ready_ram() {
		return messages_ready_ram;
	}

	public float getMessages_unacknowledged() {
		return messages_unacknowledged;
	}

	public Messages_unacknowledged_details getMessages_unacknowledged_details() {
		return Messages_unacknowledged_detailsObject;
	}

	public float getMessages_unacknowledged_ram() {
		return messages_unacknowledged_ram;
	}

	public String getName() {
		return name;
	}

	public String getNode() {
		return node;
	}

	public String getOperator_policy() {
		return operator_policy;
	}

	public String getPolicy() {
		return policy;
	}

	public String getRecoverable_slaves() {
		return recoverable_slaves;
	}

	public float getReductions() {
		return reductions;
	}

	public Reductions_details getReductions_details() {
		return Reductions_detailsObject;
	}

	public String getState() {
		return state;
	}

	public String getVhost() {
		return vhost;
	}

	// Setter Methods

	public void setArguments(Arguments argumentsObject) {
		this.ArgumentsObject = argumentsObject;
	}

	public void setAuto_delete(boolean auto_delete) {
		this.auto_delete = auto_delete;
	}

	public void setBacking_queue_status(Backing_queue_status backing_queue_statusObject) {
		this.Backing_queue_statusObject = backing_queue_statusObject;
	}

	public void setConsumer_utilisation(String consumer_utilisation) {
		this.consumer_utilisation = consumer_utilisation;
	}

	public void setConsumers(int consumers) {
		this.consumers = consumers;
	}

	public void setDurable(boolean durable) {
		this.durable = durable;
	}

	public void setExclusive(boolean exclusive) {
		this.exclusive = exclusive;
	}

	public void setExclusive_consumer_tag(String exclusive_consumer_tag) {
		this.exclusive_consumer_tag = exclusive_consumer_tag;
	}

	public void setGarbage_collection(Garbage_collection garbage_collectionObject) {
		this.Garbage_collectionObject = garbage_collectionObject;
	}

	public void setHead_message_timestamp(String head_message_timestamp) {
		this.head_message_timestamp = head_message_timestamp;
	}

	public void setIdle_since(String idle_since) {
		this.idle_since = idle_since;
	}

	public void setMemory(float memory) {
		this.memory = memory;
	}

	public void setMessage_bytes(float message_bytes) {
		this.message_bytes = message_bytes;
	}

	public void setMessage_bytes_paged_out(float message_bytes_paged_out) {
		this.message_bytes_paged_out = message_bytes_paged_out;
	}

	public void setMessage_bytes_persistent(float message_bytes_persistent) {
		this.message_bytes_persistent = message_bytes_persistent;
	}

	public void setMessage_bytes_ram(float message_bytes_ram) {
		this.message_bytes_ram = message_bytes_ram;
	}

	public void setMessage_bytes_ready(float message_bytes_ready) {
		this.message_bytes_ready = message_bytes_ready;
	}

	public void setMessage_bytes_unacknowledged(float message_bytes_unacknowledged) {
		this.message_bytes_unacknowledged = message_bytes_unacknowledged;
	}

	public void setMessage_stats(Message_stats message_statsObject) {
		this.Message_statsObject = message_statsObject;
	}

	public void setMessages(float messages) {
		this.messages = messages;
	}

	public void setMessages_details(Messages_details messages_detailsObject) {
		this.Messages_detailsObject = messages_detailsObject;
	}

	public void setMessages_paged_out(float messages_paged_out) {
		this.messages_paged_out = messages_paged_out;
	}

	public void setMessages_persistent(float messages_persistent) {
		this.messages_persistent = messages_persistent;
	}

	public void setMessages_ram(float messages_ram) {
		this.messages_ram = messages_ram;
	}

	public void setMessages_ready(float messages_ready) {
		this.messages_ready = messages_ready;
	}

	public void setMessages_ready_details(Messages_ready_details messages_ready_detailsObject) {
		this.Messages_ready_detailsObject = messages_ready_detailsObject;
	}

	public void setMessages_ready_ram(float messages_ready_ram) {
		this.messages_ready_ram = messages_ready_ram;
	}

	public void setMessages_unacknowledged(float messages_unacknowledged) {
		this.messages_unacknowledged = messages_unacknowledged;
	}

	public void setMessages_unacknowledged_details(
			Messages_unacknowledged_details messages_unacknowledged_detailsObject) {
		this.Messages_unacknowledged_detailsObject = messages_unacknowledged_detailsObject;
	}

	public void setMessages_unacknowledged_ram(float messages_unacknowledged_ram) {
		this.messages_unacknowledged_ram = messages_unacknowledged_ram;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public void setOperator_policy(String operator_policy) {
		this.operator_policy = operator_policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public void setRecoverable_slaves(String recoverable_slaves) {
		this.recoverable_slaves = recoverable_slaves;
	}

	public void setReductions(float reductions) {
		this.reductions = reductions;
	}

	public void setReductions_details(Reductions_details reductions_detailsObject) {
		this.Reductions_detailsObject = reductions_detailsObject;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setVhost(String vhost) {
		this.vhost = vhost;
	}
}

class Reductions_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Messages_unacknowledged_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Messages_ready_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Messages_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Message_stats {
	private float ack;
	Ack_details Ack_detailsObject;
	private float deliver;
	Deliver_details Deliver_detailsObject;
	private float deliver_get;
	Deliver_get_details Deliver_get_detailsObject;
	private float deliver_no_ack;
	Deliver_no_ack_details Deliver_no_ack_detailsObject;
	private float get;
	Get_details Get_detailsObject;
	private float get_no_ack;
	Get_no_ack_details Get_no_ack_detailsObject;
	private float publish;
	Publish_details Publish_detailsObject;
	private float redeliver;
	Redeliver_details Redeliver_detailsObject;

	// Getter Methods

	public float getAck() {
		return ack;
	}

	public Ack_details getAck_details() {
		return Ack_detailsObject;
	}

	public float getDeliver() {
		return deliver;
	}

	public Deliver_details getDeliver_details() {
		return Deliver_detailsObject;
	}

	public float getDeliver_get() {
		return deliver_get;
	}

	public Deliver_get_details getDeliver_get_details() {
		return Deliver_get_detailsObject;
	}

	public float getDeliver_no_ack() {
		return deliver_no_ack;
	}

	public Deliver_no_ack_details getDeliver_no_ack_details() {
		return Deliver_no_ack_detailsObject;
	}

	public float getGet() {
		return get;
	}

	public Get_details getGet_details() {
		return Get_detailsObject;
	}

	public float getGet_no_ack() {
		return get_no_ack;
	}

	public Get_no_ack_details getGet_no_ack_details() {
		return Get_no_ack_detailsObject;
	}

	public float getPublish() {
		return publish;
	}

	public Publish_details getPublish_details() {
		return Publish_detailsObject;
	}

	public float getRedeliver() {
		return redeliver;
	}

	public Redeliver_details getRedeliver_details() {
		return Redeliver_detailsObject;
	}

	// Setter Methods

	public void setAck(float ack) {
		this.ack = ack;
	}

	public void setAck_details(Ack_details ack_detailsObject) {
		this.Ack_detailsObject = ack_detailsObject;
	}

	public void setDeliver(float deliver) {
		this.deliver = deliver;
	}

	public void setDeliver_details(Deliver_details deliver_detailsObject) {
		this.Deliver_detailsObject = deliver_detailsObject;
	}

	public void setDeliver_get(float deliver_get) {
		this.deliver_get = deliver_get;
	}

	public void setDeliver_get_details(Deliver_get_details deliver_get_detailsObject) {
		this.Deliver_get_detailsObject = deliver_get_detailsObject;
	}

	public void setDeliver_no_ack(float deliver_no_ack) {
		this.deliver_no_ack = deliver_no_ack;
	}

	public void setDeliver_no_ack_details(Deliver_no_ack_details deliver_no_ack_detailsObject) {
		this.Deliver_no_ack_detailsObject = deliver_no_ack_detailsObject;
	}

	public void setGet(float get) {
		this.get = get;
	}

	public void setGet_details(Get_details get_detailsObject) {
		this.Get_detailsObject = get_detailsObject;
	}

	public void setGet_no_ack(float get_no_ack) {
		this.get_no_ack = get_no_ack;
	}

	public void setGet_no_ack_details(Get_no_ack_details get_no_ack_detailsObject) {
		this.Get_no_ack_detailsObject = get_no_ack_detailsObject;
	}

	public void setPublish(float publish) {
		this.publish = publish;
	}

	public void setPublish_details(Publish_details publish_detailsObject) {
		this.Publish_detailsObject = publish_detailsObject;
	}

	public void setRedeliver(float redeliver) {
		this.redeliver = redeliver;
	}

	public void setRedeliver_details(Redeliver_details redeliver_detailsObject) {
		this.Redeliver_detailsObject = redeliver_detailsObject;
	}
}

class Redeliver_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Publish_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Get_no_ack_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Get_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Deliver_no_ack_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Deliver_get_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Deliver_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Ack_details {
	private float rate;

	// Getter Methods

	public float getRate() {
		return rate;
	}

	// Setter Methods

	public void setRate(float rate) {
		this.rate = rate;
	}
}

class Garbage_collection {
	private float fullsweep_after;
	private float max_heap_size;
	private float min_bin_vheap_size;
	private float min_heap_size;
	private float minor_gcs;

	// Getter Methods

	public float getFullsweep_after() {
		return fullsweep_after;
	}

	public float getMax_heap_size() {
		return max_heap_size;
	}

	public float getMin_bin_vheap_size() {
		return min_bin_vheap_size;
	}

	public float getMin_heap_size() {
		return min_heap_size;
	}

	public float getMinor_gcs() {
		return minor_gcs;
	}

	// Setter Methods

	public void setFullsweep_after(float fullsweep_after) {
		this.fullsweep_after = fullsweep_after;
	}

	public void setMax_heap_size(float max_heap_size) {
		this.max_heap_size = max_heap_size;
	}

	public void setMin_bin_vheap_size(float min_bin_vheap_size) {
		this.min_bin_vheap_size = min_bin_vheap_size;
	}

	public void setMin_heap_size(float min_heap_size) {
		this.min_heap_size = min_heap_size;
	}

	public void setMinor_gcs(float minor_gcs) {
		this.minor_gcs = minor_gcs;
	}
}

class Backing_queue_status {
	private float avg_ack_egress_rate;
	private float avg_ack_ingress_rate;
	private float avg_egress_rate;
	private float avg_ingress_rate;
	ArrayList<Object> delta = new ArrayList<Object>();
	private float len;
	private String mode;
	private float next_seq_id;
	private float q1;
	private float q2;
	private float q3;
	private float q4;
	private String target_ram_count;

	// Getter Methods

	public float getAvg_ack_egress_rate() {
		return avg_ack_egress_rate;
	}

	public float getAvg_ack_ingress_rate() {
		return avg_ack_ingress_rate;
	}

	public float getAvg_egress_rate() {
		return avg_egress_rate;
	}

	public float getAvg_ingress_rate() {
		return avg_ingress_rate;
	}

	public float getLen() {
		return len;
	}

	public String getMode() {
		return mode;
	}

	public float getNext_seq_id() {
		return next_seq_id;
	}

	public float getQ1() {
		return q1;
	}

	public float getQ2() {
		return q2;
	}

	public float getQ3() {
		return q3;
	}

	public float getQ4() {
		return q4;
	}

	public String getTarget_ram_count() {
		return target_ram_count;
	}

	// Setter Methods

	public void setAvg_ack_egress_rate(float avg_ack_egress_rate) {
		this.avg_ack_egress_rate = avg_ack_egress_rate;
	}

	public void setAvg_ack_ingress_rate(float avg_ack_ingress_rate) {
		this.avg_ack_ingress_rate = avg_ack_ingress_rate;
	}

	public void setAvg_egress_rate(float avg_egress_rate) {
		this.avg_egress_rate = avg_egress_rate;
	}

	public void setAvg_ingress_rate(float avg_ingress_rate) {
		this.avg_ingress_rate = avg_ingress_rate;
	}

	public void setLen(float len) {
		this.len = len;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setNext_seq_id(float next_seq_id) {
		this.next_seq_id = next_seq_id;
	}

	public void setQ1(float q1) {
		this.q1 = q1;
	}

	public void setQ2(float q2) {
		this.q2 = q2;
	}

	public void setQ3(float q3) {
		this.q3 = q3;
	}

	public void setQ4(float q4) {
		this.q4 = q4;
	}

	public void setTarget_ram_count(String target_ram_count) {
		this.target_ram_count = target_ram_count;
	}
}

class Arguments {

	// Getter Methods

	// Setter Methods

}