package controller;

import Service.IProductService;
import Service.ProductService;
import model.Product;
import model.ProductForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")

public class HomeController {
    @Value("${file-upload}")
    private String fileUpload;
    private final IProductService iProductService = new ProductService();

    @GetMapping("")
    public String show(Model model) {

        List<Product> list = iProductService.finall();
        model.addAttribute("list", list);
        return "/index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", new ProductForm());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImg();
//        lấy ra tên file được up
        String fileName = multipartFile.getOriginalFilename();
        try {
//            coppy file được gửi lên và tạo file mới gửi đến đường link được hướng tới
            FileCopyUtils.copy(productForm.getImg().getBytes(), new File("/Users/tam/IdeaProjects/Bai4_md4/thuc_hanh3/src/main/webapp" + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(),
                productForm.getEmail(), fileName);
        iProductService.save(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }

}
