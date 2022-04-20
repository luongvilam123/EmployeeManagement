import React from 'react';
import "./congvieclist.scss";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import LuongDataTable from "../../components/datatable/LuongTable";

const LuongList = () =>
{
    return (
        <div className="list">
            <Sidebar/>
            <div className="listContainer">
                <Navbar/>

                <LuongDataTable/>

            </div>
        </div>
    );
};

export default LuongList;