package com.example.rickAndMorty.test.common.utils

class StringUtil {
    companion object{

        fun getID(delimiter:String, data:String): String{
            val split=data.split(delimiter)

            return split[1]
        }


        fun splitString(data:List<String>  ): String{
            return data.joinToString(",")
        }
    }
}