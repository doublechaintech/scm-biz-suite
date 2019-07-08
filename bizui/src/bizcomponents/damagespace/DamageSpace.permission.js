

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
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


const internalSummaryOf = (damageSpace,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{damageSpace.id}</Description> 
<Description term="Location">{damageSpace.location}</Description> 
<Description term="Contact Number">{damageSpace.contactNumber}</Description> 
<Description term="Total Area">{damageSpace.totalArea}</Description> 
<Description term="Latitude">{damageSpace.latitude}</Description> 
<Description term="Longitude">{damageSpace.longitude}</Description> 
<Description term="Last Update Time">{ moment(damageSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
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
    const  damageSpace = this.props.damageSpace;
    const { id,displayName, goodsShelfCount } = damageSpace
    const cardsData = {cardsName:"Damage Space",cardsFor: "damageSpace",cardsSource: damageSpace,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  damageSpace: state._damageSpace,
}))(Form.create()(DamageSpacePermission))

