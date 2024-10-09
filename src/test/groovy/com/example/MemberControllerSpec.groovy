package com.example

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class MemberControllerSpec extends Specification implements ControllerUnitTest<MemberController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
