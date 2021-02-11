package org.eclipse.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.main.Calcul;
import org.eclipse.main.CalculService;
import org.junit.Rule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

class CalculTest {
	Calcul calcul;
	//CalculService calculService = mock(CalculService.class);

	//CalculService calculService = new CalculService() {

	//	@Override
	//	public int carre(int x) {
	//		return x * x;
	//	}
	//};
	@Mock
	CalculService calculService;
	@Rule
	MockitoRule rule = MockitoJUnit.rule();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach");
		MockitoAnnotations.initMocks(this);
		calcul = new Calcul(calculService);
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach");
		calcul = null;
	}

	@Test
	void testSommeCarre() {
		// assertTrue("calcul exact",calcul.sommeCarre(2,3) ==13);
		when(calculService.carre(2)).thenReturn(4);
		when(calculService.carre(3)).thenReturn(9);
		assertTrue("calcul exact", calcul.sommeCarre(2, 3) == 13);
		verify(calculService).carre(2);
	}

	@Test
	void testSomme() {
		System.out.println("TestSomme");
		if (calcul.somme(2, 3) != 5)
			fail("faux pour deux entiers positifs");
		if (calcul.somme(-2, -3) != -5)
			fail("faux pour deux entiers negatifs");
		if (calcul.somme(-2, 3) != 1)
			fail("faux pour deux entiers de signe different");
		if (calcul.somme(0, 3) != 3)
			fail("faux pour x nul");
		if (calcul.somme(2, 0) != 2)
			fail("faux pour y nul");
		if (calcul.somme(0, 0) != 0)
			fail("faux pour x et y nuls");
	}

	@Test
	void testDivision() {
		System.out.println("TestDivision");
		assertFalse("2entiers positifs", calcul.division(6, 3) == 0);
		assertEquals("2entiers negatifs", 2, calcul.division(-6, -3));
		assertNotNull("2 entiers de signe different", calcul.division(-6, 3));
		assertTrue("entier x nul", calcul.division(0, 3) == 0);
		Throwable e = null;
		try {
			calcul.division(2, 0);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof ArithmeticException);
		e = null;
		try {
			calcul.division(0, 0);
		} catch (Throwable ex) {
			e = ex;
		}
		assertTrue(e instanceof ArithmeticException);
	}

}
