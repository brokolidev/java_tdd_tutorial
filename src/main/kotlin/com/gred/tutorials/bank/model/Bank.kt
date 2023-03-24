package com.gred.tutorials.bank.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Bank(
    @JsonProperty("goods_id")
    val accountNumber: String,

    @JsonProperty("stock")
    val trust: Double,

    @JsonProperty("list_price")
    val transactionFee: Int
)