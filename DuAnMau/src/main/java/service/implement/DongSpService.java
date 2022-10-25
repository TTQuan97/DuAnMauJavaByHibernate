package service.implement;

import domainmodel.DongSP;
import java.util.ArrayList;
import java.util.List;
import repository.implement.DongSpRepository;
import repository.IDongSpRepository;
import service.IDongSpService;
import viewmodel.DongSpViewModel;

/**
 *
 * @author trant
 */
public class DongSpService implements IDongSpService {

    private IDongSpRepository DongRepo;

    public DongSpService() {
        DongRepo = new DongSpRepository();
    }

    @Override
    public List<DongSpViewModel> getAllDongSp() {
        var listDong = DongRepo.getAllDongSp();
        List<DongSpViewModel> listView = new ArrayList<>();
        for (DongSP dongSP : listDong) {
            listView.add(new DongSpViewModel(dongSP.getMa(), dongSP.getTen()));
        }
        return listView;
    }

    @Override
    public String insertDong(String maDong, String tenDong) {
        return DongRepo.insertDong(maDong, tenDong);
    }

    @Override
    public void updateDong(DongSpViewModel dongView, String ma, String ten) {
        DongSP dong = DongRepo.getDongSpFromMa(dongView.getMa());
        DongRepo.updateDong(dong, ma, ten);
    }

    @Override
    public void deleteDongSp(String maDong) {
        DongRepo.deleteDongSp(maDong);
    }

    @Override
    public String getIdFromMa(String maDong) {
        String id = null;
        if (DongRepo.getDongSpFromMa(maDong) == null) {
            return id;
        } else {
            return id = DongRepo.getDongSpFromMa(maDong).getId();
        }
    }

}
