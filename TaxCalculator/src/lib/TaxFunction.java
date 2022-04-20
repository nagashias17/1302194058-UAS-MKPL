package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	public static int calculateTax(Salary salary, int numberOfMonthWorking, Spouse spouse, int numberOfChildren) {
		
		int tax = 0;
		
		CalnumberOfMonthWorking(numberOfMonthWorking);
		CalnumberOfChildren(numberOfChildren);

		if (spouse.getSpouseIdNumber().equals("")) {
			tax = IsMarried(salary,numberOfMonthWorking, numberOfChildren);
		}else {
			tax = NotMarried(salary, numberOfMonthWorking);
		}

		return checkTax(tax);
	}

	public static void CalnumberOfMonthWorking(int numberOfMonthWorking) {
	if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
	}

	public static void CalnumberOfChildren() {
	if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
	}


	public static int IsMarried(Salary salary, int numberOfMonthWorking, int numberOfChildren) {
		return (int) Math.round(0.05 * (Income(salary, numberOfMonthWorking)) - salary.getAnnualDeductible() - (54000000 + 4500000 + (numberOfChildren * 1500000)));
	}

	public static int NotMarried(Salary salary, int numberOfMonthWorking){
		return (int) Math.round(0.05 * ((Income(salary, numberOfMonthWorking)) - salary.getAnnualDeductible() - 54000000));
	}

	public static int Income(Salary salary, int numberOfMonthWorking){
		return ((salary.getMonthlySalary() + salary.getOtherMonthlyIncome()) * numberOfMonthWorking);
	}

	public static int checkTax(int tax){
		
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
	}
}
