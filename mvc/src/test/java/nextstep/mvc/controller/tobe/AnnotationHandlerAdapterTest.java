package nextstep.mvc.controller.tobe;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.servlet.http.HttpServletRequest;

class AnnotationHandlerAdapterTest {

	private AnnotationHandlerMapping handlerMapping;
	private AnnotationHandlerAdapter annotationHandlerAdapter;

	@BeforeEach
	void setUp() {
		handlerMapping = new AnnotationHandlerMapping("samples");
		annotationHandlerAdapter = new AnnotationHandlerAdapter();
		handlerMapping.initialize();
	}

	@DisplayName("AnnotationHandlerAdapter 에 인스턴스 값을 확인한다.")
	@Test
	void supports() {
		final var request = mock(HttpServletRequest.class);

		when(request.getRequestURI()).thenReturn("/get-test");
		when(request.getMethod()).thenReturn("GET");

		final var handlerExecution = (HandlerExecution)handlerMapping.getHandler(request);
		final boolean expected = annotationHandlerAdapter.supports(handlerExecution);
		// then
		Assertions.assertTrue(expected);
	}
}