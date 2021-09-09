

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './DamageSpace.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (damageSpace,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{damageSpace.id}</Description> 
<Description term="位置">{damageSpace.location}</Description> 
<Description term="联系电话">{damageSpace.contactNumber}</Description> 
<Description term="总面积">{damageSpace.totalArea}</Description> 
<Description term="纬度">{damageSpace.latitude}</Description> 
<Description term="经度">{damageSpace.longitude}</Description> 
<Description term="更新于">{ moment(damageSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = damageSpace => {
  const {DamageSpaceBase} = GlobalComponents
  return <PermissionSetting targetObject={damageSpace}  targetObjectMeta={DamageSpaceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class DamageSpacePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  damageSpace = this.props.damageSpace
    const { id,displayName, goodsShelfCount } = damageSpace
    const  returnURL = `/damageSpace/${id}/workbench`
    const cardsData = {cardsName:"残次货物存放区",cardsFor: "damageSpace",cardsSource: damageSpace,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  damageSpace: state._damageSpace,
}))(Form.create()(DamageSpacePermission))

