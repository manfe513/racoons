/*-------------------------------------------------------
Лабораторная работа №5
Оценка качества ПО по ГОСТ 28195-89
Расчет фактора надежности прикладной программы для 
научных исследований для фазы сопровождения
-------------------------------------------------------*/

import java.util.Random;
import java.util.Arrays;

public class Software_QA {
	public static void main(String args[]) {
		//число зарегистрированных отказов
		int Q = Integer.parseInt(args[0]);
		//число экспериментов
		int N = Integer.parseInt(args[1]);
		
		//среднее время восстановления (интервал)
		double TrMin = Double.parseDouble(args[2]);
		double TrMax = Double.parseDouble(args[3]);
		int Tnr = Integer.parseInt(args[4]);
		
		//допустимое время восстановления cек.
		double Tdr = Double.parseDouble(args[5]);
		
		//фактическая продолжительность 
		//преобразования i-го входного набора данных
		double TtMin = Double.parseDouble(args[6]);
		double TtMax = Double.parseDouble(args[7]);
		int Tnt = Integer.parseInt(args[8]);
		
		//допустимое время преобразования i-го 
		//входного набора данных сек.
		double Tdt = Double.parseDouble(args[9]);
		
		//базовые критерии надежности
		double Pbas = Double.parseDouble(args[10]);
		
		
		double P = P(Q, N);
		
		
		double Qrs = 0;
		
		for (int i = 0; i < Tnr; i++) {
			Qrs += Qr(random(TrMin, TrMax), Tdr);
		}
		
		Qrs /= Tnr;
		
		
		double Qts = 0;
		
		for (int i = 0; i < Tnt; i++) {
			Qts += Qt(random(TtMin, TtMax), Tdt);
		}
		
		Qts /= Tnt;
		
		
		double Pm24 = Pmjk(P);
		double Pm25 = Pmjk(Qrs, Qts);
		
		double P12 = Pij(Pm24, Pm25);
		double K12 = Kij(P12, Pbas);
		double Kf1 = Kfi(K12);
		
		System.out.println("Вероятность безотказной " 
		+ "работы: " + P + ";");
		
		System.out.println("Оценка по среднему времени "
		+ "восстановления: " + Qrs + ";");
		
		System.out.println("Оценка по продолжительности "
		+ "преобразования входного набора данных в "
		+ "выходной: " + Qts + ";");
		
		System.out.println("Итоговая оценка 4-й метрики "
		+ "2-го критерия: " + Pm24 + ";");
		
		System.out.println("Итоговая оценка 5-й метрики "
		+ "2-го критерия: " + Pm25 + ";");
		
		System.out.println("Абсолютные показатели "
		+ "критериев 1-го фактора качества: " 
		+ P12 + ";");
		
		System.out.println("Относительный показатель "
		+ "2-го критерия 1-го фактора качества: "
		+ K12 + ";");
		
		System.out.println("Фактор качества: " + Kf1 
		+ ";");
	}
	
	//генерация в интервале
	public static double random(double min, double max) {
		return Math.random() * (max - min) + min;
	}
	
	/*---------------------------------------------------
	
	---------------------------------------------------*/
	
	//итоговая оценка k-й метрики j-го критерия
	public static double Pmjk(double ... Mkq) {
		return Arrays.stream(Mkq).sum() / Mkq.length;
	}
	
	//абсолютные показатели критериев i-го фактора
	//качества
	public static double Pij(double ... Pmjk) {
		return Arrays.stream(Pmjk).sum() / Pmjk.length;
	}
	
	//относительный показатель j-го критерия i-го
	//фактора качества
	public static double Kij(double Pij, double Pbasij) {
		return Pij / Pbasij;
	}
	
	//фактор качества
	public static double Kfi(double ... Kij) {
		return Arrays.stream(Kij).sum() / Kij.length;
	}
	
	/*--------------------------------------------
	Оценочные элементы фактора «надежность ПС»
	--------------------------------------------*/
	
	//вероятность безотказной работы
	public static double P(double Q, double N) {
		return 1 - Q / N;
	}
	
	//оценка по среднему времени восстановления
	public static double Qr(double Tr, double Tdr) {
		return (Tr <= Tdr) ? 1 : Tdr / Tr;
	}
	
	//оценка по продолжительности преобразования
	//входного набора данных в выходной
	public static double Qt(double Tt, double Tdt) {
		return (Tt <= Tdt) ? 1 : Tdt / Tt;
	}
}