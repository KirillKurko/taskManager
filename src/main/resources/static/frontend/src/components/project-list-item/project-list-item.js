export default function ProjectListItem({id, name, shortName, description}) {
    return (
        <tr className="table-row">
            <td className="table-data project-id">{id}</td>
            <td className="table-data project-name">{name}</td>
            <td className="table-data project-short-name">{shortName}</td>
            <td className="table-data project-description">{description}</td>
        </tr>
    );
}