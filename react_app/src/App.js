import Home from "./pages/home/Home";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import CongViecList from "./pages/list/CongViecList";
import CongViecSingle from "./pages/single/CongViecSingle";
import CongViecNew from "./pages/new/CongViecNew";
import NhanVienList from "./pages/list/NhanVienList";
import PhongBanList from "./pages/list/PhongBanList";
import DuAnList from "./pages/list/DuAnList";
import DuAnSingle from "./pages/single/DuAnSingle";
import DuAnNew from "./pages/new/DuAnNew";
import ChucVuList from "./pages/list/ChucVuList";
import ChucVuSingle from "./pages/single/ChucVuSingle";
import ChucVuNew from "./pages/new/ChucVuNew";
import ChamCongList from "./pages/list/ChamCongList";
import LuongList from "./pages/list/LuongList";
import NhanVienSingle from "./pages/single/NhanVienSingle";
import NhanVienNew from "./pages/new/NhanVienNew";
import PhongBanNew from "./pages/new/PhongBanNew";
import PhongBanSingle from "./pages/single/PhongBanSingle";
function App()
{
    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path="/">
                        <Route index element={<Home/>}/>

                        {/*<Route path="login" element={<Login />} />*/}

                        <Route path="nhanvien">
                            <Route index element={<NhanVienList/>}/>
                            <Route path=":nhanvienID" element={<NhanVienSingle/>}/>
                            <Route path="edit/:nhanvienID" element={<NhanVienNew/>}/>
                            <Route path="new" element={<NhanVienNew/>}/>
                        </Route>

                        <Route path="phongban">
                            <Route index element={<PhongBanList/>}/>
                            <Route path=":phongbanID" element={<PhongBanSingle/>}/>
                            <Route path="new" element={<PhongBanNew/>}/>
                        </Route>

                        <Route path="duan">
                            <Route index element={<DuAnList/>}/>
                            <Route path=":duanID" element={<DuAnSingle/>}/>
                            <Route path="new" element={<DuAnNew/>}/>
                        </Route>

                        <Route path="congviec">
                            <Route index element={<CongViecList/>}/>
                            <Route path=":congviecID" element={<CongViecSingle/>}/>
                            <Route path="new" element={<CongViecNew/>}/>
                        </Route>

                        <Route path="chucvu">
                            <Route index element={<ChucVuList/>}/>
                            <Route path=":chucvuID" element={<ChucVuSingle/>}/>
                            <Route path="new" element={<ChucVuNew/>}/>
                        </Route>

                        <Route path="chamcong">
                            <Route index element={<ChamCongList/>}/>
                            {/*<Route path=":congviecID" element={<CongViecSingle/>}/>*/}
                            {/*<Route path="new" element={<CongViecNew/>}/>*/}
                        </Route>
                        <Route path="luong">
                            <Route index element={<LuongList/>}/>
                            {/*<Route path=":congviecID" element={<CongViecSingle/>}/>*/}
                            {/*<Route path="new" element={<CongViecNew/>}/>*/}
                        </Route>
                    </Route>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
