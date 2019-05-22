
import React from 'react'
import { Link } from 'dva/router'
import {
    Menu,
    Icon,
  } from 'antd'
import PermissionSettingService from '../permission/PermissionSetting.service'
import appLocaleName from './Locale.tool'
import {sessionObject} from '../utils/utils'


const  {  filterForMenuPermission } = PermissionSettingService



const defaultIsMenuItemForDisplay = (item, targetObject, targetComponent) => {
    return true
  }
  
  const defaultFilteredMenuItems = (targetObject, targetComponent) => {
      const menuData = sessionObject('menuData')
      const isMenuItemForDisplayFunc = targetComponent.props.isMenuItemForDisplayFunc||defaultIsMenuItemForDisplay
      return menuData.subItems.filter(item=>filterForMenuPermission(item,targetObject,targetComponent)).filter(item=>isMenuItemForDisplayFunc(item,targetObject,targetComponent))
  }
  const defaultFilteredNoGroupMenuItems = (targetObject, targetComponent) => {
      return defaultFilteredMenuItems(targetObject, targetComponent).filter(item=>item.viewGroup==='__no_group')
  }
  
  const defaultFilteredMenuItemsGroup = (targetObject, targetComponent) => {
    const groupedMenuItems = []
  
    defaultFilteredMenuItems(targetObject, targetComponent).filter(item=>item.viewGroup!=='__no_group').map(item=>{
      const {viewGroup} = item
     
      let result = groupedMenuItems.find(viewGroupItem=>(viewGroupItem.viewGroup===viewGroup))
  
      if(!result){
        // group not found
        result = {viewGroup, subItems: []}
        groupedMenuItems.push(result)
      }
      
      const {subItems} = result
      subItems.push(item)
      return item
      
    })
    
    return groupedMenuItems
  }
  
  const defaultRenderMenuItem=(item,targetObject,targetComponent)=>{
  
    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
    const {objectId}=targetApp;
    const userContext = null
    return (<Menu.Item key={item.name}>
      <Link to={`/${menuData.menuFor}/${objectId}/list/${item.name}/${item.displayName}${appLocaleName(userContext,"List")}`}>
      <Icon type="bars" /><span>{item.displayName}</span>
      </Link>
    </Menu.Item>)
  
  
  }

  const BizAppTool = {

    defaultIsMenuItemForDisplay,
    defaultFilteredMenuItems,
    defaultFilteredNoGroupMenuItems,
    defaultFilteredMenuItemsGroup,
    defaultRenderMenuItem,

  }

  export default BizAppTool