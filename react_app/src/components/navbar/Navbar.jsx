import React from 'react';
import "./navbar.scss"
import SearchOutlinedIcon from '@mui/icons-material/SearchOutlined';
// import LanguageOutlinedIcon from '@mui/icons-material/LanguageOutlined';
// import DarkModeOutlinedIcon from '@mui/icons-material/DarkModeOutlined';
// import FullscreenExitOutlinedIcon from '@mui/icons-material/FullscreenExitOutlined';
// import NotificationsOutlinedIcon from '@mui/icons-material/NotificationsOutlined';
// import ChatBubbleOutlineOutlinedIcon from '@mui/icons-material/ChatBubbleOutlineOutlined';
// import ListAltOutlinedIcon from '@mui/icons-material/ListAltOutlined';

const Navbar = () =>
{
    return (
        <div className="navbar">
            <div className="wrapper">

                <div className="search">
                    {/*<input/>*/}
                    {/*<SearchOutlinedIcon/>*/}
                </div>

                <div className="items">
                    {/*<div className="item">*/}
                    {/*    <LanguageOutlinedIcon className="icon"/>*/}
                    {/*    VietNamese*/}
                    {/*</div>*/}
                    {/*<div className="item">*/}
                    {/*    <DarkModeOutlinedIcon className="icon"/>*/}
                    {/*</div>*/}
                    {/*<div className="item">*/}
                    {/*    <FullscreenExitOutlinedIcon className="icon"/>*/}
                    {/*</div>*/}
                    {/*<div className="item">*/}
                    {/*    <NotificationsOutlinedIcon className="icon"/>*/}
                    {/*    <div className="counter">*/}
                    {/*        1*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                    {/*<div className="item">*/}
                    {/*    <ChatBubbleOutlineOutlinedIcon className="icon"/>*/}
                    {/*    <div className="counter">*/}
                    {/*        2*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                    <div className="item" style={{color: "#537895", fontWeight: "bold", fontSize: "15px"}}>
                        Xin Chào, Admin
                    </div>
                    <div className="item">
                        <img className="avatar"
                             src="https://scontent.fsgn13-2.fna.fbcdn.net/v/t1.6435-1/126847369_1514969715368207_1417788622934334776_n.jpg?stp=dst-jpg_p160x160&_nc_cat=109&ccb=1-5&_nc_sid=7206a8&_nc_ohc=wfqJ9vOBLeQAX9_h2xO&_nc_ht=scontent.fsgn13-2.fna&oh=00_AT8NVi-iJokVb3ez5Tyn-OOsKv7aAQ4MP9did7xnjqcjIw&oe=6286BA23"
                             alt="Ảnh"/>
                    </div>
                </div>

            </div>
        </div>
    );
};

export default Navbar;