import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"双链小超省中心", menuFor: "retailStoreProvinceCenter",
  		subItems: [
  {name: 'provinceCenterEmployeeList', displayName:'省中心员工', icon:'align-center',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreCityServiceCenterList', displayName:'双链小超城市服务中心', icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  founded: '成立',
  country: '国',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreProvinceCenter') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.country, dataIndex: 'country', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreProvinceCenter,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreProvinceCenter.id}>
	
      <DescriptionList  key={retailStoreProvinceCenter.id} size="small" col="4">
        <Description term="序号">{retailStoreProvinceCenter.id}</Description> 
        <Description term="名称">{retailStoreProvinceCenter.name}</Description> 
        <Description term="成立"><div>{ moment(retailStoreProvinceCenter.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term="最后更新时间"><div>{ moment(retailStoreProvinceCenter.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const RetailStoreProvinceCenterBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreProvinceCenterBase



