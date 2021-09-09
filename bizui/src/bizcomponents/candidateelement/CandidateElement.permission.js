

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './CandidateElement.profile.less'
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
const internalSummaryOf = (candidateElement,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{candidateElement.id}</Description> 
<Description term="标题">{candidateElement.name}</Description> 
<Description term="类型">{candidateElement.type}</Description> 
<Description term="图像"><ImagePreview imageTitle="图像" imageLocation={candidateElement.image}/></Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = candidateElement => {
  const {CandidateElementBase} = GlobalComponents
  return <PermissionSetting targetObject={candidateElement}  targetObjectMeta={CandidateElementBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class CandidateElementPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  candidateElement = this.props.candidateElement
    const { id,displayName,  } = candidateElement
    const  returnURL = `/candidateElement/${id}/workbench`
    const cardsData = {cardsName:"候选人元素",cardsFor: "candidateElement",cardsSource: candidateElement,displayName,returnURL,
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
  candidateElement: state._candidateElement,
}))(Form.create()(CandidateElementPermission))

