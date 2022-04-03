import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun abnormal_parameters_for_the_second_transfer() {
        val transfer2 = 99_000_658
        val lastTransfer = 25_000_768
        val typeCard = "Mir"

        val result = calculateCommission(amountTransfer = transfer2,lastTransfer = lastTransfer, typeCard = typeCard)
        assertEquals("Тут ошибка" , result)
    }

    @Test
    fun normal_parameters_for_the_second_transfer() {
        val transfer2 = 10_000
        val lastTransfer = 600_000
        val typeCard = "Mir"

        val result = calculateCommission(amountTransfer = transfer2,lastTransfer = lastTransfer, typeCard = typeCard)
        assertEquals("Комиссия в копейках составляет: 3500 копеек" , result)
    }

    @Test
    fun abnormal_parameters_for_the_first_transfer() {
        val transfer1 = 10_000_658
        val lastTransfer = 25_000_768

        val result = calculateCommission(amountTransfer = transfer1,lastTransfer = lastTransfer)
        assertEquals("" , result)
    }

    @Test
    fun normal_parameters_for_the_first_transfer() {
        val transfer1 = 10_000
        val lastTransfer = 25_000

        val result = calculateCommission(amountTransfer = transfer1,lastTransfer = lastTransfer)
        assertEquals("Комиссия в копейках составляет: 0 копеек" , result)
    }

    @Test
    fun calculate_commission_when_transfer_8_000_000_and_last_transfer_10_000_type_card_Mir() {
        val count = 8_000_000
        val lastTransfer = 100000
        val typeCard = "Mir"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransfer,typeCard = typeCard)
        assertEquals("Комиссия в копейках составляет: 60000 копеек" , result)
    }

    @Test
    fun calculate_commission_when_transfer_100_000_000_and_last_transfer_10_000_type_card_Mir() {
        val count = 100_000_000
        val lastTransferVK = 100000
        val typeCard = "Mir"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK,typeCard = typeCard)
        assertEquals("" , result)
    }

    @Test
    fun calculate_commission_when_transfer_8_000_000_and_last_transfer_100_000_000_type_card_Mir() {
        val count = 8_000_000
        val lastTransferVK = 100_000_000
        val typeCard = "Mir"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK,typeCard = typeCard)
        assertEquals("" , result)
    }

    @Test
    fun calculate_commission_when_transfer_8_000_000_and_last_transfer_100_000_000_type_card_Mastercard() {
        val count = 8_000_000
        val lastTransferVK = 100_000_000
        val typeCard = "Mastercard"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK,typeCard = typeCard)
        assertEquals("" , result)
    }

    @Test
    fun calculate_commission_when_transfer_100_000_000_and_last_transfer_0_type_card_Mastercard() {
        val count = 100_000_000
        val lastTransferVK = 0
        val typeCard = "Mastercard"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK,typeCard = typeCard)
        assertEquals("" , result)
    }

    @Test
    fun calculate_commission_when_transfer_8_000_000_and_last_transfer_10_000_type_card_Mastercard() {
        val count = 8_000_000
        val lastTransferVK = 100000
        val typeCard = "Mastercard"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK,typeCard = typeCard)
        assertEquals("Комиссия в копейках составляет: 48020 копеек" , result)
    }

    @Test
    fun calculate_commission_when_transfer_100_000_000_and_last_transfer_10_000_type_card_Mastercard() {
        val count = 100_000_000
        val lastTransferVK = 100000
        val typeCard = "Mastercard"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK,typeCard = typeCard)
        assertEquals("" , result)
    }

    @Test
    fun calculate_commission_when_transfer_100_000_and_last_transfer_10_000_type_card_Mastercard() {
        val count = 100_000
        val lastTransferVK = 100000
        val typeCard = "Mastercard"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK,typeCard = typeCard)
        assertEquals("Комиссия в копейках составляет: 0 копеек" , result)
    }

    @Test
    fun calculate_commission_when_transfer_100_000_000_and_last_transfer_10_000_type_card_Visa() {
        val count = 100_000_000
        val lastTransferVK = 100000
        val typeCard = "Visa"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK,typeCard = typeCard)
        assertEquals("" , result)
    }

    @Test
    fun calculate_commission_when_transfer_10_000_000_and_last_transfer_10_000_type_card_Visa() {
        val count = 10_000_000
        val lastTransferVK = 100000
        val typeCard = "Visa"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK,typeCard = typeCard)
        assertEquals("Комиссия в копейках составляет: 75000 копеек" , result)
    }

    @Test
    fun calculate_commission_when_transfer_10_000_and_last_transfer_0_type_card_Visa() {
        val count = 10_000
        val lastTransferVK = 0
        val typeCard = "Visa"

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK,typeCard = typeCard)
        assertEquals("Комиссия в копейках составляет: 3500 копеек" , result)
    }

    @Test
    fun calculate_commission_when_transfer_10_000_and_last_transfer_100000_type_card_empty() {
        val count = 10_000
        val lastTransferVK = 100000

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK)
        assertEquals("Комиссия в копейках составляет: 0 копеек" , result)
    }

    @Test
    fun calculate_commission_when_transfer_10_000_and_last_transfer_0_type_card_empty() {
        val count = 10_000
        val lastTransferVK = 0

        val result = calculateCommission(amountTransfer = count,lastTransfer = lastTransferVK)
        assertEquals("Комиссия в копейках составляет: 0 копеек" , result)
    }

    @Test
    fun limit_exceeded_normal_status_another_card() {
        val count = 6_000_000
        val typeCard = "Visa"
        val lastTransfer = 25_000

        val result = checkTheLimit(count, typeCard, lastTransfer)
        assertEquals(false, result)
    }

    @Test
    fun limit_exceeded_normal_status_VKPay() {
        val count = 1_000_000
        val typeCard = "VKPay"
        val lastTransfer = 25_000

        val result = checkTheLimit(count, typeCard, lastTransfer)
        assertEquals(false, result)
    }

    @Test
    fun limit_exceeded_with_VKPay() {
        val count = 16_000_000
        val typeCard = "VKPay"
        val lastTransfer = 25_000

        val result = checkTheLimit(count, typeCard, lastTransfer)
        assertEquals(true, result)
    }

    @Test
    fun limit_exceeded_with_another() {
        val count = 16_000_000
        val typeCard = "Mastercard"
        val lastTransfer = 25_000

        val result = checkTheLimit(count, typeCard, lastTransfer)
        assertEquals(true, result)
    }

    @Test
    fun limit_exceeded_with_totalTransferredVK_max() {
        val count = 1_000_000
        val typeCard = "VKPay"
        val lastTransfer = 25_000

        val result = checkTheLimit(count, typeCard, lastTransfer)
        assertEquals(false, result)
    }

    @Test
    fun limit_exceeded_with_totalTransferredVK_min() {
        val count = 1_000_000
        val typeCard = "VKPay"
        val lastTransfer = 25_000

        val result = checkTheLimit(count, typeCard, lastTransfer)
        assertEquals(false, result)
    }

    @Test
    fun limit_exceeded_with_totalTransferred_max_and_another_card() {
        val count = 1_000_000
        val typeCard = "Visa"
        val lastTransfer = 25_000

        val result = checkTheLimit(count, typeCard, lastTransfer)
        assertEquals(false, result)
    }

    @Test
    fun limit_exceeded_with_totalTransferred_min_and_another_card() {
        val count = 1_000_000
        val typeCard = "Visa"
        val lastTransfer = 25_000

        val result = checkTheLimit(count, typeCard, lastTransfer)
        assertEquals(false, result)
    }

    @Test
    fun calculate_commission_Visa_and_Mir_when_count_1_000() {
        val count = 1_000

        val result = calculateCommissionVisaMir(count)
        assertEquals(3500, result)
    }

    @Test
    fun calculate_commission_another_card() {
        val count = 1_000
        val typeCard = "Tinkoff"
        val lastTrans = 342

        val result = calculateCommission(typeCard = typeCard, amountTransfer = count, lastTransfer = lastTrans)
        assertEquals("Комиссия в копейках составляет: Введенная карта на поддерживается!", result)
    }

    @Test
    fun calculate_commission_Visa_and_Mir_when_count_3_000_000() {
        val count = 3_000_000

        val result = calculateCommissionVisaMir(count)
        assertEquals(22500, result)
    }

    @Test
    fun calculate_commission_mastercard_or_maestro_when_count_605_700() {
        val count = 605_700

        val result = calculateCommissionMastercardMaestro(count)
        assertEquals(0, result)
    }

    @Test
    fun calculate_commission_mastercard_or_maestro_when_count_1_000() {
        val count = 1_000

        val result = calculateCommissionMastercardMaestro(count)
        assertEquals(26, result)
    }

    @Test
    fun calculate_commission_VKPay_when_count_1256() {
        val count = 1256

        val result = calculateCommissionVKPay(count)
        assertEquals(0, result)
    }

    @Test
    fun show_ending_when_kopecks_12() {
        val kopecks = 12

        val result = showKopecksToString(kopecks)
        assertEquals("12 копеек", result)
    }

    @Test
    fun show_ending_when_kopecks_33() {
        val kopecks = 33

        val result = showKopecksToString(kopecks)
        assertEquals("33 копейки", result)
    }

    @Test
    fun show_ending_when_kopecks_73451() {
        val kopecks = 73451

        val result = showKopecksToString(kopecks)
        assertEquals("73451 копейка", result)
    }
}