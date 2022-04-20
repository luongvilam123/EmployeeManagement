import React from 'react';
import "./sidebar.scss"
import DashboardIcon from '@mui/icons-material/Dashboard';
import AccountCircleOutlinedIcon from '@mui/icons-material/AccountCircleOutlined';
import BusinessOutlinedIcon from '@mui/icons-material/BusinessOutlined';
import AccountTreeOutlinedIcon from '@mui/icons-material/AccountTreeOutlined';
import TimelapseOutlinedIcon from '@mui/icons-material/TimelapseOutlined';
import PaidOutlinedIcon from '@mui/icons-material/PaidOutlined';
import WorkOutlinedIcon from '@mui/icons-material/WorkOutlined';
import RadarOutlinedIcon from '@mui/icons-material/RadarOutlined';
import ListItemText from '@mui/material/ListItemText';
// import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
// import DraftsIcon from '@mui/icons-material/Drafts';
import ListItemIcon from '@mui/material/ListItemIcon';
import {Link} from 'react-router-dom'

const Sidebar = () => {
    return (
        <div className="sidebar">

            <div className="top">
                <span className="logo">QLNS APP</span>
            </div>

            <hr/>

            <div className="center">
                <ul>
                    <p className="title">
                        MAIN
                    </p>
                    {/*<li>*/}
                    {/*    <DashboardIcon className="icon"/>*/}
                    {/*    <span>Trang chủ</span>*/}
                    {/*</li>*/}
                    <Link to="/" style={{textDecoration: "none"}}>
                        <ListItemButton className="listItem">
                            <ListItemIcon>
                                <DashboardIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Trang Chủ" className="itemText"/>
                        </ListItemButton>
                    </Link>

                    <p className="title">
                        MENU
                    </p>

                    <Link to="/nhanvien" style={{textDecoration: "none"}}>
                        <ListItemButton className="listItem">
                            <ListItemIcon>
                                <AccountCircleOutlinedIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Nhân Viên" className="itemText"/>
                        </ListItemButton>
                    </Link>

                    <Link to="/phongban" style={{textDecoration: "none"}}>
                        <ListItemButton className="listItem">
                            <ListItemIcon>
                                <BusinessOutlinedIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Phòng Ban" className="itemText"/>
                        </ListItemButton>
                    </Link>

                    <Link to="/duan" style={{textDecoration: "none"}}>
                        <ListItemButton className="listItem">
                            <ListItemIcon>
                                <AccountTreeOutlinedIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Dự Án" className="itemText"/>
                        </ListItemButton>
                    </Link>


                    <Link to="/congviec" style={{textDecoration: "none"}}>
                        <ListItemButton className="listItem">
                            <ListItemIcon>
                                <WorkOutlinedIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Công Việc" className="itemText"/>
                        </ListItemButton>
                    </Link>

                    <Link to="/chucvu" style={{textDecoration: "none"}}>
                        <ListItemButton className="listItem">
                            <ListItemIcon>
                                <RadarOutlinedIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Chức Vụ" className="itemText"/>
                        </ListItemButton>
                    </Link>

                    <Link to="/chamcong" style={{textDecoration: "none"}}>
                        <ListItemButton className="listItem">
                            <ListItemIcon>
                                <TimelapseOutlinedIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Chấm Công" className="itemText"/>
                        </ListItemButton>
                    </Link>

                    <Link to="/luong" style={{textDecoration: "none"}}>
                        <ListItemButton className="listItem">
                            <ListItemIcon>
                                <PaidOutlinedIcon className="icon"/>
                            </ListItemIcon>
                            <ListItemText primary="Lương" className="itemText"/>
                        </ListItemButton>
                    </Link>


                </ul>
            </div>

            <hr className="rr"/>

            {/*<div className="bottom">*/}
            {/*    <div className="colorOption"/>*/}
            {/*    <div className="colorOption"/>*/}
            {/*</div>*/}
        </div>
    );
};

export default Sidebar;