package com.gred.tutorials.bank.datasource.network.dto

import com.gred.tutorials.bank.datasource.BankDataSource
import com.gred.tutorials.bank.model.Bank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSource(
    @Autowired private val restTemplate: RestTemplate
) : BankDataSource {
    override fun retrieveBanks(): Collection<Bank> {
        val response: ResponseEntity<ProductList> =
            restTemplate
                .getForEntity("http://43.200.75.240:15301/api/v1/foodspring/goods/search?query=콜라&delivery=all&from=1&vendor_ids=1517&size=100")

        return response.body?.results?.documents
            ?: throw IOException("검색 요청이 올바르지 않습니다.")
    }

    override fun retrieveBank(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun removeBank(accountNumber: String) {
        TODO("Not yet implemented")
    }
}