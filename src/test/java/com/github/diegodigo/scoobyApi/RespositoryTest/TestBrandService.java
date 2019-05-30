package com.github.diegodigo.scoobyApi.RespositoryTest;

import com.github.diegodigo.scoobyApi.domain.Brand;
import com.github.diegodigo.scoobyApi.repository.BrandRepository;
import com.github.diegodigo.scoobyApi.service.BrandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBrandService {

    @Autowired
    private BrandService brandService;

    @MockBean
    private BrandRepository brandRepository;

    @Test
    public void testGetBrands() {
        when(brandRepository.findAll()).thenReturn(
                Stream.of(new Brand("teste 1"), new Brand("teste 2"))
                        .collect(Collectors.toList())
        );
        assertEquals(2, brandService.findAll().size());
    }

    public void createBrand() {
        Brand brand = new Brand("nome brand");
        when(brandRepository.save(brand)).thenReturn(brand);
        assertEquals("nome brand", brand.getName());
    }

}
