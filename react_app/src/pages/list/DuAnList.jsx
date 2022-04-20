import React from 'react';
import "./congvieclist.scss";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import DuAnDataTable from "../../components/datatable/DuAnTable";

const DuAnList = () =>
{
    return (
        <div className="list">
            <Sidebar/>
            <div className="listContainer">
               <Navbar/>

               <DuAnDataTable/>

            </div>
        </div>
    );
};

export default DuAnList;