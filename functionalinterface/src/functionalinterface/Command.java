package functionalinterface;

import java.util.Objects;

public interface Command<T, U, R> {
	
	R handle(T req,U headers);
	
	default <V> Command<T, U, V> andThen (Command<? super R, ? super U, ? extends V> after){
		Objects.requireNonNull(after);
		return (t, u) -> {
			return after.handle(this.handle(t, u), u);
		};
	}
	
	
}
