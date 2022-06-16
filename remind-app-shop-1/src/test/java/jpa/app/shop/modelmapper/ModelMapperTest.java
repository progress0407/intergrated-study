package jpa.app.shop.modelmapper;

import jpa.app.shop.controller.form.MemberForm;
import jpa.app.shop.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

public class ModelMapperTest {

    ModelMapper modelMapper = new ModelMapper();

    @DisplayName("MemberForm -> Address")
    @Test
    void memberForm_address() {
        MemberForm form = new MemberForm();
        form.setCity("CITY A");
        form.setStreet("STREET A");
        form.setZipcode("ZIP CODE A");

        Address address = modelMapper.map(form, Address.class);

        System.out.println("address = " + address);
    }

    @DisplayName("MemberForm -> Address 2")
    @Test
    void memberForm_address_2() {
        MemberForm form = new MemberForm();
        form.setCity("CITY A");
        form.setStreet("STREET A");
        form.setZipcode("ZIP CODE A");

        modelMapper
                .typeMap(MemberForm.class, Address.class)
                .addMappings(mapper -> {
                    mapper.map(MemberForm::getCity, Address::setCity);
                    mapper.map(MemberForm::getStreet, Address::setStreet);
                    mapper.map(MemberForm::getZipcode, Address::setZipcode);
                });
        Address address = modelMapper.map(form, Address.class);
        System.out.println("address = " + address);
    }

    @DisplayName("qwe2")
    @Test
    void qwe2() {
        MemberDto memberDto = new MemberDto("NAME A", 30L, "ADDRESS A");
        Member member = modelMapper.map(memberDto, Member.class);

        System.out.println("member = " + member);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class MemberDto {
        private String name;
        private Long age;
        private String address;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Member {
        private String name;
        private Long age;
        private String address;
    }
}
