fun main() {
    val typeCardVK = "VKPay"
    val typeCardMastercard = "Mastercard"
    val typeCardMaestro = "Maestro"
    val typeCardMir = "Mir"
    val typeCardVisa = "Visa"
    val lastTransfer = 25_000

    val transfer1 = 10_000
    val transfer2 = 600_000
//    val transfer3 = 8_000_000
//    val transfer4 = 20_000_000

    println(calculateCommission(amountTransfer = transfer1,lastTransfer = lastTransfer))
    println(calculateCommission(typeCardMir, transfer2, lastTransfer))
//    println(calculateCommission(typeCardMastercard, transfer3, lastTransfer))
//    println(calculateCommission(typeCardVK, transfer4, lastTransfer))
}

fun calculateCommission(typeCard: String = "VKPay", amountTransfer: Int, lastTransfer: Int): String {
    println("Сумма перевода составляет: ${showKopecksToString(amountTransfer)}")
    if (checkTheLimit(amountTransfer, typeCard, lastTransfer)) return ""
    val commission = when(typeCard) {
        "Mastercard","Maestro" -> showKopecksToString(calculateCommissionMastercardMaestro(amountTransfer))
        "Mir", "Visa" -> showKopecksToString(calculateCommissionVisaMir(amountTransfer))
        "VKPay" -> showKopecksToString(calculateCommissionVKPay(amountTransfer))
        else -> "Введенная карта на поддерживается!"
    }
    return "Комиссия в копейках составляет: $commission"
}

fun checkTheLimit(count: Int, typeCard: String, lastTransfer: Int): Boolean {
    if (typeCard == "VKPay" && (lastTransfer + count) > 4_000_000) {
        println("Превышен максимум переводов за месяц!")
        return true
    } else if ((lastTransfer + count) > 60_000_000){
        println("Превышен максимум переводов за месяц!")
        return true
    }

    if (typeCard == "VKPay" && count > 1_500_000) {
        println("Превышен максимум единовременного перевода!")
        return true
    } else if (count > 15_000_000){
        println("Превышен максимум единовременного перевода!")
        return true
    }

    return false
}

fun calculateCommissionVisaMir(count: Int): Int {
    val minimalCommission = 3_500
    val commission = (count * 75 / 10_000)
    return if (commission > minimalCommission) commission else minimalCommission
}

fun calculateCommissionMastercardMaestro(count: Int): Int {
    return if (count in 30_000..7_500_000) 0 else (count * 6 / 1_000) + 20
}

fun calculateCommissionVKPay(count: Int): Int {
    return 0
}

fun showKopecksToString(kopecks: Int): String {
    val resultString: String

    return if (kopecks % 10 == 1 && kopecks != 11) {
        "$kopecks копейка"
    } else if (kopecks % 10 in 2..4 && kopecks > 20 || kopecks in 2..4) {
        "$kopecks копейки"
    } else {
        "$kopecks копеек"
    }
}
