package com.example

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MemberSpec extends Specification implements DomainUnitTest<Member> {

     void "test domain constraints"() {
        when:
        Member domain = new Member()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
